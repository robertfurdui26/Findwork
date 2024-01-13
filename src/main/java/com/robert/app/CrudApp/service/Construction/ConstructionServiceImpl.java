package com.robert.app.CrudApp.service;

import com.robert.app.CrudApp.Dto.CreateContstructionDto;
import com.robert.app.CrudApp.Dto.GetConstructionDto;
import com.robert.app.CrudApp.model.Construction;
import com.robert.app.CrudApp.repository.ConstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConstructionServiceImpl implements ConstructionService {

    @Autowired
    private ConstructionRepository consRepository;

    public ConstructionServiceImpl(ConstructionRepository consRepository){
        this.consRepository = consRepository;
    }

    public GetConstructionDto createConstruction(CreateContstructionDto createDto){
        Construction createConstruction = toEntity(createDto);
        Construction saveCreateDto = consRepository.save(createConstruction);
        return toDto(saveCreateDto);
    }

    public Construction toEntity(CreateContstructionDto createDto){
        Construction construction = new Construction();
        construction.setServiceName(createDto.getServiceName());
        construction.setDescription(createDto.getDescription());
        construction.setAddress(createDto.getAddress());
        construction.setPhone(createDto.getPhone());
        // Set other fields as needed
        return construction;
    }


    @Override
    public List<GetConstructionDto> getAllConstructions() {
        List<Construction> constructionList=  consRepository.findAll();
        return  constructionList.stream()
                .map(it -> toDto(it))
                .collect(Collectors.toList());
    }

    public GetConstructionDto toDto(Construction construction){
        return new GetConstructionDto(
                construction.getId(),
                construction.getServiceName(),
                construction.getDescription(),
                construction.getAddress(),
                construction.getPhone());
    }
}
