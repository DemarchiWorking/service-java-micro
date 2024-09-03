package com.example.servico.controller;

import com.example.servico.dtos.ServiceRecordDto;
import com.example.servico.model.Project;
import com.example.servico.model.Servicee;
import com.example.servico.service.ProjectService;
import com.example.servico.service.ServiceService;
import com.example.servico.service.feign.ServiceClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    // adicionar id no payload <<
    @PostMapping("/andamento")
    public ResponseEntity<Map<String,String>> sendProceeding(@RequestBody Project project) {
        try{
            projectService.issueProgress(project);
        }catch (JsonProcessingException e){

        }
        return ResponseEntity.ok(Map.of("message:", "servico gerado"));
        //return serviceService.save(serviceDto);
    }
    @PostMapping("/rabbitmq")
    public ResponseEntity<Map<String,String>> sendProject(@RequestBody Project project) {
        try{
            projectService.issueProject(project);
        }catch (JsonProcessingException e){

        }
        return ResponseEntity.ok(Map.of("message:", "servico gerado"));
        //return serviceService.save(serviceDto);
    }
    @PostMapping("/")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {

        return projectService.createProject(project);
    }
    @GetMapping("/")
    public ResponseEntity<List<Project>> getProjects() {
        return projectService.getProjects();

    }
    @DeleteMapping("{id}")
    public ResponseEntity<Project> excluirProject (@PathVariable Long id){

        return projectService.excluirProject(id);
    }
    @PutMapping("{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
        return projectService.updateProject(id, project);
    }
}
