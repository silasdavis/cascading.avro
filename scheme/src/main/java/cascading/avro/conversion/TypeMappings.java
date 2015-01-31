package cascading.avro.conversion;

import cascading.tuple.Tuple;
import cascading.tuple.TupleEntry;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSetMultimap;
import org.apache.avro.AvroRuntimeException;
import org.apache.avro.Schema;
import org.apache.avro.specific.SpecificData;
import org.apache.hadoop.io.BytesWritable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeMappings {
    protected static final ImmutableMultimap<Class<?>, Schema.Type> TO_AVRO_TYPE_MULTIMAP = new ImmutableSetMultimap.Builder<Class<?>, Schema.Type>()
        .put(Integer.class, Schema.Type.INT)
        .put(Long.class, Schema.Type.LONG)
        .put(Boolean.class, Schema.Type.BOOLEAN)
        .put(Double.class, Schema.Type.DOUBLE)
        .put(Float.class, Schema.Type.FLOAT)
        .put(BytesWritable.class, Schema.Type.BYTES)
        .put(byte[].class, Schema.Type.BYTES)
        .put(TupleEntry.class, Schema.Type.RECORD)
        .put(List.class, Schema.Type.ARRAY)
        .put(Map.class, Schema.Type.MAP)
        .putAll(String.class, Schema.Type.STRING, Schema.Type.ENUM)
        .putAll(Tuple.class, Schema.Type.ARRAY, Schema.Type.MAP)
        .build();

    protected static final ImmutableMultimap<Schema.Type, Class<?>> FROM_AVRO_TYPE_MULTIMAP = TO_AVRO_TYPE_MULTIMAP.inverse();

    public static ImmutableCollection<Schema.Type> getDestinationTypes(Class<?> c) {
        return TO_AVRO_TYPE_MULTIMAP.get(c);
    }

    public static boolean isMappable(Class<?> c, Schema.Type t) {
        for (Class<?> baseClass : FROM_AVRO_TYPE_MULTIMAP.get(t)) {
            return baseClass.isAssignableFrom(c);
        }
        try {
            return SpecificData.get().getSchema(c).getType() == t;
        }
        catch (AvroRuntimeException e) {
            return false;
        }
    }

    public static HashMap asMap(Object tuple) {
        return asMap((Tuple) tuple, 0);
    }

    public static HashMap asMapDeep(Object tuple) {
        return asMap((Tuple) tuple, -1);
    }

    @SuppressWarnings({"unchecked"})
    public static HashMap asMap(Tuple tuple, int depth) {
        if (tuple.size() % 2 != 0)
            throw new IllegalArgumentException("Cannot convert Tuple to map; odd number of elements.");
        HashMap map = new HashMap(tuple.size() / 2);
        for (int i = 0; i < tuple.size(); i += 2) {
            Object value = tuple.getObject(i + 1);
            map.put(tuple.getObject(i), depth != 0 && value instanceof Tuple ? asMap((Tuple) value, depth - 1) : value);
        }
        return map;
    }
}
