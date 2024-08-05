package com.example.servico.repository;

import com.example.servico.model.Servicee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Servicee, Long> {


    List<Servicee> findAllByProjectId(Long projectId);

}