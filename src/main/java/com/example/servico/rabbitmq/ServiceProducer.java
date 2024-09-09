package com.example.servico.rabbitmq;

import com.example.servico.dtos.ServiceRecordDto;
import com.example.servico.model.Servicee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;
    public void send(ServiceRecordDto service) throws JsonProcessingException {
        log.info("enviando service:{}", service);
        amqpTemplate.convertAndSend("service-exc", "service-rk", objectMapper.writeValueAsString(service));

    }
}
