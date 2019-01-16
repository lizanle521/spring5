package com.example.jsondesirializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * @author lizanle
 * @data 2019/1/16 下午3:13
 */
@JsonComponent
public class MyJsonComponent {

//    public static class MySerializer extends JsonSerializer {
//        @Override
//        public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//            jsonGenerator.writeObject(o);
//        }
//    }

//    public static class MyDeserializer extends StdDeserializer {
//        protected MyDeserializer(Class vc) {
//            super(vc);
//        }
//
//        @Override
//        public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
//            return ctxt;
//        }
//    }
}
