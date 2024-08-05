package com.example.servico.dtos;

import java.math.BigDecimal;

public record ServiceRecordDto(String name, Long projectId, BigDecimal cost, String description){

}