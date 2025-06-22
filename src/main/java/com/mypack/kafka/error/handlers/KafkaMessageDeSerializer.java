package com.mypack.kafka.error.handlers;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypack.beans.Employee;

/**
 * This class is not in use.
 * */
public class KafkaMessageDeSerializer extends ErrorHandlingDeserializer<Employee> implements Deserializer<Employee>{
  @Override
  public Employee deserialize(String s, byte[] bytes) {
    System.out.println(":::::::::::::::::::::::::: deserialize(String s, byte[] bytes):::::::::::::::::::::::");
      if (bytes == null) {
          return null;
      }
      ObjectMapper objectMapper = new ObjectMapper();
      try {
          return objectMapper.readValue(new String(bytes, StandardCharsets.UTF_8), Employee.class);
      } catch (Exception e) {
          throw new SerializationException("Error when  deserializing byte[] to messageDto");
      }
  }
  
  @Override
  public void configure(Map<String, ?> map, boolean b) {}
  
  @Override
  public void close() {}
}
