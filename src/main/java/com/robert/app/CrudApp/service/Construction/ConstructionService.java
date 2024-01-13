package com.robert.app.CrudApp.service;

import com.robert.app.CrudApp.Dto.CreateContstructionDto;
import com.robert.app.CrudApp.Dto.GetConstructionDto;
import com.robert.app.CrudApp.model.Construction;

import java.util.List;

public interface ConstructionService {

     GetConstructionDto createConstruction(CreateContstructionDto createDto);

     List<GetConstructionDto> getAllConstructions();

}
