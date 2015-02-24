package cascading.avro.serialization;

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.avro.Schema;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.hadoop.io.serializer.avro.AvroSerialization;

/**
 * This class provides a serialization for into Java classes served by SpecificData - this includes all Avro-generated
 * Java classes, as well as some plain old Java classes used by Avro.
 * <p/>
 * This allows for serialization of Avro objects embedded in cascading tuples during intermediate serialization such
 * as during a reduce phase. Add it to the list with the other serialization classes in the JobConf "io.serializations"
 * property. The order is important; place this serializer earlier in the list than those serializations you wish to override.
 *
 * @param <T> The type to serialize/deserialize.
 */
public class AvroSpecificDataSerialization<T> extends AvroSerialization<T> {
  @Override
  public boolean accept(Class<?> c) {
    return getSchema(c) != null;
  }

  @Override
  public Schema getSchema(T t) {
    return getSchema(t.getClass());
  }

  @Override
  public DatumWriter<T> getWriter(Class<T> clazz) {
    // Schema set by superclass before write
    return new SpecificDatumWriter<T>();
  }

  @Override
  public DatumReader<T> getReader(Class<T> clazz) {
    return new SpecificDatumReader<T>(getSchema(clazz));
  }

  protected Schema getSchema(Class<?> clazz){
    return SpecificData.get().getSchema(clazz);
  }
}
