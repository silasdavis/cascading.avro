package cascading.avro.serialization;

import cascading.avro.generated.Test1;
import cascading.avro.generated.TestEnum;
import cascading.avro.generated.md51;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.apache.commons.compress.utils.Charsets;
import org.apache.hadoop.io.serializer.Deserializer;
import org.apache.hadoop.io.serializer.Serialization;
import org.apache.hadoop.io.serializer.Serializer;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class AvroSpecificDataSerializationTest {
  @Test
  public void testRoundTrip() throws IOException {
    HashFunction hf = Hashing.md5();
    HashCode hc = hf.newHasher()
        .putLong(23423434234l)
        .putString("Fooness", Charsets.UTF_8)
        .hash();
    md51 md5 = new md51(hc.asBytes());

    Test1 test = Test1.newBuilder()
        .setAFixed(md5)
        .setABoolean(true)
        .setANull(null)
        .setAList(new ArrayList<Integer>())
        .setAMap(new HashMap<CharSequence, Integer>())
        .setAUnion(2)
        .setABytes(ByteBuffer.wrap(new byte[]{3, 4}))
        .build();

    TestEnum te = TestEnum.valueOf("ONE");

    roundTripEquals(test, new Test1());
    roundTripEquals(md5, new md51());
    roundTripEquals(te, null);
    roundTripEquals(test, null);
    roundTripEquals(md5, null);
  }

  private void roundTripEquals(Object test, Object testOut) throws IOException {
    Serialization serialization = new AvroSpecificDataSerialization<Test1>();
    Serializer serializer = serialization.getSerializer(test.getClass());
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    serializer.open(out);
    serializer.serialize(test);
    serializer.close();

    Deserializer deserializer = serialization.getDeserializer(test.getClass());
    ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
    deserializer.open(in);
    testOut = deserializer.deserialize(testOut);
    deserializer.close();

    assertEquals(test, testOut);
  }
}
