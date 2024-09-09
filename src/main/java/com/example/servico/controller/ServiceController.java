package com.example.servico.controller;

import com.example.servico.dtos.ServiceRecordDto;
import com.example.servico.model.Servicee;
import com.example.servico.service.ServiceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @PostMapping("/rabbitmq")
    public ResponseEntity<Map<String,String>> sendService(@RequestBody ServiceRecordDto serviceDto) {
        try{
            System.out.println("test");
            serviceService.emitirServico(serviceDto);
        }catch (JsonProcessingException e){

        }
        return ResponseEntity.ok(Map.of("message:", "servico gerado"));

        //return serviceService.save(serviceDto);
    }
    @PostMapping("/")
    public ResponseEntity<Servicee> createService(@RequestBody ServiceRecordDto serviceDto) {
        return serviceService.save(serviceDto);
    }
    @GetMapping("/")
    public ResponseEntity<List<Servicee>> getAllServices(){
        return serviceService.getAllService();
    }
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Servicee>> getAllServicesByProjectId(@PathVariable Long projectId){
        return serviceService.getAllServicesByProjectId(projectId);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Servicee> getServiceById(@PathVariable Long serviceId){
        return serviceService.findById(serviceId);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity excluirService (@PathVariable Long id){
        return this.serviceService.deleteById(id);
    }
}