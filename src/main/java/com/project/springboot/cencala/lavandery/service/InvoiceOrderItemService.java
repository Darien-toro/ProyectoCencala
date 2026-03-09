package com.project.springboot.cencala.lavandery.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springboot.cencala.lavandery.dto.InvoiceOrderItemDTO;
import com.project.springboot.cencala.lavandery.entity.InvoiceOrderItemEntity;
import com.project.springboot.cencala.lavandery.mapper.InvoiceOrderItemMapper;
import com.project.springboot.cencala.lavandery.repository.InvoiceOrderItemRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceOrderItemService {

    private final InvoiceOrderItemRepository invoiceOrderItemRepository;
    private final InvoiceOrderItemMapper invoiceOrderItemMapper;

    @Transactional(readOnly = true)
    public List<InvoiceOrderItemDTO> getAll() {
        return invoiceOrderItemRepository.findAll()
                                         .stream()
                                         .map(invoiceOrderItemMapper::toDto)
                                         .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<InvoiceOrderItemDTO> getId(Integer invoiceOrderId) {
        return invoiceOrderItemRepository.findByInvoiceOrderEntity_Id(invoiceOrderId)
                                         .stream()
                                         .map(invoiceOrderItemMapper::toDto)
                                         .collect(Collectors.toList());
    }

    @Transactional
    public InvoiceOrderItemDTO update(Integer id, InvoiceOrderItemDTO dto) {
        InvoiceOrderItemEntity entity = invoiceOrderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item no encontrado"));
        entity.setTotalAmount(dto.getTotalAmount());
        entity.setCompensationAmount(dto.getCompensationAmount());
        return invoiceOrderItemMapper.toDto(invoiceOrderItemRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) {
        invoiceOrderItemRepository.deleteById(id);
    }
}