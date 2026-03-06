package com.project.springboot.cencala.lavandery.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.cencala.lavandery.dto.LegIdTypeDto;
import com.project.springboot.cencala.lavandery.service.LegIdTypeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/apis")
public class LegIdTypeController {

    private final LegIdTypeService legIdTypeService;

    @GetMapping
    public List<LegIdTypeDto> finAll(){
        return legIdTypeService.findAll();
    }

    @GetMapping("/{id}")
    public LegIdTypeDto getTypeId(@PathVariable Integer id){
        return legIdTypeService.getTypeId(id);
    }

    @PostMapping
    public LegIdTypeDto saveId(@RequestBody LegIdTypeDto dto){
        return legIdTypeService.saveId(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        legIdTypeService.deleteTypeID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LegIdTypeDto> updateLegIdType(@PathVariable Integer id, @RequestBody LegIdTypeDto dto){
        LegIdTypeDto update = legIdTypeService.updateLegIdType(id, dto);
        return ResponseEntity.ok(update);
    }
}
