package com.example.servico.controller;

import com.example.servico.dtos.ServiceRecordDto;
import com.example.servico.model.Project;
import com.example.servico.model.Servicee;
import com.example.servico.service.ProjectService;
import com.example.servico.service.ServiceService;
import com.example.servico.service.feign.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

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
