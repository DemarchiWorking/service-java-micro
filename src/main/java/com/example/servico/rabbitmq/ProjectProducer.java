package com.example.servico.rabbitmq;

import com.example.servico.dtos.ServiceRecordDto;
import com.example.servico.model.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;
    public void send(Project project) throws JsonProcessingException {
        amqpTemplate.convertAndSend("project-exc", "project-rk", objectMapper.writeValueAsString(project));

    }
    public void sendProgress(Project project) throws JsonProcessingException {
        amqpTemplate.convertAndSend("andamento-exc", "andamento-rk", objectMapper.writeValueAsString(project));

    }
}
