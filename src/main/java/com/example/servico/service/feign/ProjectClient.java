package com.example.servico.service.feign;

import com.example.servico.model.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "PROJETO-SERVICE")
public interface ProjectClient {
    @GetMapping("/project/{id}")
    ResponseEntity<Project> getProjectById(@PathVariable Long id);
    //@PostMapping("/project")
    //ResponseEntity<Servicee> save(Servicee servicee);
    @RequestMapping(method = RequestMethod.POST, value = "/project/", consumes = "application/json")
     ResponseEntity<Project> createProject(@RequestBody Project project);
    @GetMapping("/project/")
    ResponseEntity<List<Project>> getProjects();
    @DeleteMapping("/project/{id}")
    ResponseEntity<Project> excluirProject (@PathVariable Long id);
    @PutMapping("/project/{id}")
    ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project);
}
