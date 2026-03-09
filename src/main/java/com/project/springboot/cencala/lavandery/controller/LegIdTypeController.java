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
@RequestMapping("/api/legal-id-type")
public class LegIdTypeController {

    private final LegIdTypeService legIdTypeService;

    @GetMapping
    public List<LegIdTypeDto> finAll(){
        return legIdTypeService.findAll();
    }

    @GetMapping("/{id}")
    public LegIdTypeDto findById(@PathVariable Integer id){
        return legIdTypeService.findById(id);
    }

    @PostMapping
    public LegIdTypeDto save(@RequestBody LegIdTypeDto dto){
        return legIdTypeService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        legIdTypeService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LegIdTypeDto> update(@PathVariable Integer id, @RequestBody LegIdTypeDto dto){
        dto.setId(id);
        LegIdTypeDto update = legIdTypeService.update(id, dto);
        return ResponseEntity.ok(update);
    }
}
