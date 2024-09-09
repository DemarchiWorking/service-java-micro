package com.example.servico.service;

import com.example.servico.dtos.ServiceRecordDto;
import com.example.servico.model.Project;
import com.example.servico.model.Servicee;
import com.example.servico.rabbitmq.ProjectProducer;
import com.example.servico.rabbitmq.ServiceProducer;
import com.example.servico.service.feign.ProjectClient;
import com.example.servico.service.feign.ServiceClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectClient client;
    private final ProjectProducer producer;
    public void issueProgress(Project project) throws JsonProcessingException {
        producer.sendProgress(project);
    }
    public void issueProject (Project project) throws JsonProcessingException {
        producer.send(project);
    }


    public ResponseEntity<?> createProject(Project project) throws JsonProcessingException {
        issueProject(project);
        return ResponseEntity.ok().build();
        //return client.createProject(project);
    }

    public ResponseEntity<List<Project>> getProjects() {
        return client.getProjects();

    }
    public ResponseEntity<Project> excluirProject(Long id)
    {
        return client.excluirProject(id);
    }
    public ResponseEntity<Project> updateProject(Long id, Project project) {
        return client.updateProject(id, project);
    }
}
