package com.project.springboot.cencala.lavandery.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springboot.cencala.lavandery.dto.InvoiceOrderDTO;
import com.project.springboot.cencala.lavandery.entity.InvoiceOrderEntity;
import com.project.springboot.cencala.lavandery.mapper.InvoiceOrderMapper;
import com.project.springboot.cencala.lavandery.repository.InvoiceOrderRepository;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceOrderService {

    private final InvoiceOrderRepository invoiceOrderRepository;
    private final InvoiceOrderMapper invoiceOrderMapper;

       // Llamar al procedimiento almacenado de MySQL
    @Transactional
    public void processInvoiceOrders(int month, int year) {
        invoiceOrderRepository.processInvoiceOrder(month, year);
    }
    
    // Obtener todas las facturas
    @Transactional(readOnly = true)
    public List<InvoiceOrderDTO> getAllOrders() {
        return invoiceOrderRepository.findAll()
                                     .stream()
                                     .map(invoiceOrderMapper::toDTO)
                                     .collect(Collectors.toList());
    }

    // Obtener una factura por ID
    @Transactional(readOnly = true)
    public InvoiceOrderDTO getOrderById(Integer id) {
        return invoiceOrderRepository.findById(id)
                .map(invoiceOrderMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }

    // Actualizar una factura
    @Transactional
    public InvoiceOrderDTO updateOrder(Integer id, InvoiceOrderDTO dto) {
        InvoiceOrderEntity entity = invoiceOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        entity.setCode(dto.getCode());
        entity.setInvoiceNumber(dto.getInvoiceNumber());
        entity.setOrderCount(dto.getOrderCount());
        entity.setTotalAmount(dto.getTotalAmount());
        entity.setCompensationAmount(dto.getCompensationAmount());
        return invoiceOrderMapper.toDTO(invoiceOrderRepository.save(entity));
    }

    // Eliminar una factura
    @Transactional
    public void deleteOrder(Integer id) {
        invoiceOrderRepository.deleteById(id);
    }
}
