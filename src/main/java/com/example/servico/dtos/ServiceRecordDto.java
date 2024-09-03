package com.example.servico.dtos;

import java.math.BigDecimal;

public record ServiceRecordDto(String name, BigDecimal cost,Long projectId, String description){

}