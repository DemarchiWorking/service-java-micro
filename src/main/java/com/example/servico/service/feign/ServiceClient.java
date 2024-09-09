package com.example.servico.service.feign;

import com.example.servico.model.Project;
import com.example.servico.model.Servicee;
import com.example.servico.service.ServiceResponsePayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("PROJETO-SERVICE")
public interface ServiceClient {

    @GetMapping("/project/{id}")
    ResponseEntity<Project> getProjectById(@PathVariable Long id);
    //@PostMapping("/project")
    //ResponseEntity<Servicee> save(Servicee servicee);
    @PostMapping("/project/")
    ResponseEntity<Project> createProject(@RequestBody Project project);

}
