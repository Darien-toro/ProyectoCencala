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

    // Obtener todos los ítems
    @Transactional(readOnly = true)
    public List<InvoiceOrderItemDTO> getAllItems() {
        return invoiceOrderItemRepository.findAll()
                                         .stream()
                                         .map(invoiceOrderItemMapper::toDTO)
                                         .collect(Collectors.toList());
    }

    // Obtener ítems por ID de factura
    @Transactional(readOnly = true)
    public List<InvoiceOrderItemDTO> getItemsByInvoiceOrderId(Integer invoiceOrderId) {
        return invoiceOrderItemRepository.findByInvoiceOrderEntity_Id(invoiceOrderId)
                                         .stream()
                                         .map(invoiceOrderItemMapper::toDTO)
                                         .collect(Collectors.toList());
    }

    // Actualizar un ítem
    @Transactional
    public InvoiceOrderItemDTO updateItem(Integer id, InvoiceOrderItemDTO dto) {
        InvoiceOrderItemEntity entity = invoiceOrderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item no encontrado"));
        entity.setTotalAmount(dto.getTotalAmount());
        entity.setCompensationAmount(dto.getCompensationAmount());
        return invoiceOrderItemMapper.toDTO(invoiceOrderItemRepository.save(entity));
    }

    // Eliminar un ítem
    @Transactional
    public void deleteItem(Integer id) {
        invoiceOrderItemRepository.deleteById(id);
    }
}