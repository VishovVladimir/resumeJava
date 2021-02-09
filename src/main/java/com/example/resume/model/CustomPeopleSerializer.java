package com.example.resume.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CustomPeopleSerializer extends StdSerializer<People> {
    protected CustomPeopleSerializer() {
        this(null);
    }

    protected CustomPeopleSerializer(Class<People> t) {
        super(t);
    }


    @Override
    public void serialize(People people, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectFieldStart("attribute 1");
        jsonGenerator.writeStringField("field", "id");
        jsonGenerator.writeNumberField("value", people.getId());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeObjectFieldStart("attribute 2");
        jsonGenerator.writeStringField("field", "name");
        jsonGenerator.writeStringField("value", people.getName());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndObject();

    }
}
