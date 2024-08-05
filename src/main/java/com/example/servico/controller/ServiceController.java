package com.example.servico.controller;

import com.example.servico.dtos.ServiceRecordDto;
import com.example.servico.model.Servicee;
import com.example.servico.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @PostMapping
    public ResponseEntity<Servicee> creaSteService(@RequestBody ServiceRecordDto serviceDto) {
        return serviceService.save(serviceDto);
    }
    @GetMapping
    public ResponseEntity<List<Servicee>> getAllServices(){
        return serviceService.getAllService();
    }
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Servicee>> getAllServicesByProjectId(@PathVariable Long projectId){
        return serviceService.getAllServicesByProjectId(projectId);
    }
    @GetMapping("{id}")
    public ResponseEntity<Servicee> getServiceById(@PathVariable Long serviceId){
        return serviceService.findById(serviceId);
    }
    @DeleteMapping("{id}")
    public ResponseEntity excluirService (@PathVariable Long id){
        return this.serviceService.deleteById(id);
    }
}

