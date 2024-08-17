package com.example.servico.service;

import com.example.servico.dtos.ServiceRecordDto;
import com.example.servico.model.Project;
import com.example.servico.model.Servicee;
import com.example.servico.repository.ServiceRepository;
import com.example.servico.service.feign.ServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ServiceService {
    private final ServiceClient client;
    //@Autowired
    //private HistoricoService historicoService;
    @Autowired
    private ServiceRepository serviceRepository;


    @Transactional
    public ResponseEntity<Servicee> save(ServiceRecordDto serviceDto){

        Servicee service = new Servicee();
        service.setName(serviceDto.name());

        service.setCost(serviceDto.cost());
        service.setDescription(serviceDto.description());
            var project = client.getProjectById(serviceDto.projectId()).getBody();
            /*
            RestClient restClient = RestClient.create();
            String serverUrl = String.format("http://localhost:8088/project/%d", serviceDto.projectId());
            Project project = restClient.get()
                    .uri(serverUrl)
                    .retrieve()
                    .toEntity(Project.class).getBody();
            //log.info(.getName());
            */

        if (project.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Return 400 Bad Request
        }else {
            service.setProjectId(project.getId());

        }
        Servicee saved_service = serviceRepository.save(service);
        //historicoService.newLog(Historico.OPERACAO.CRIAR, "Serviço", "ID: " +   saved_service.getId().toString(), "");
        return ResponseEntity.ok(saved_service);
    }
    public ResponseEntity<List<Servicee>> getAllService() {
        return ResponseEntity.ok(serviceRepository.findAll());
    }

    public ResponseEntity<List<Servicee>> getAllServicesByProjectId(@PathVariable Long projectId) {
        return ResponseEntity.ok(serviceRepository.findAllByProjectId(projectId));
    }


    public ResponseEntity<Servicee> findById(@PathVariable Long id) {
        Servicee service = serviceRepository.findById(id).orElse(null);

        if (service == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Return 400 Bad Request
        }else{
            return ResponseEntity.ok(service);
        }
    }
    public ResponseEntity deleteById(@PathVariable Long id) {
        Servicee service = serviceRepository.findById(id).orElse(null);

        if (service == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Return 400 Bad Request
        }else{
            //historicoService.newLog(Historico.OPERACAO.APAGAR, "Serviço", "", "ID: " +  id.toString());
            serviceRepository.deleteById(id);
            return ResponseEntity.ok(service);
        }
    }

}

