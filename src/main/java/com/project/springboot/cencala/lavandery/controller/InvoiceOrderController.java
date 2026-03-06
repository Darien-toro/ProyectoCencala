package com.project.springboot.cencala.lavandery.controller;

import com.project.springboot.cencala.lavandery.dto.InvoiceOrderDTO;
import com.project.springboot.cencala.lavandery.service.InvoiceOrderService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/invoice-orders")
@AllArgsConstructor
public class InvoiceOrderController {

    private final InvoiceOrderService invoiceOrderService;

    // Obtener todas las facturas
    @GetMapping
    public List<InvoiceOrderDTO> getAllOrders() {
        return invoiceOrderService.getAllOrders();
    }

    // Obtener una factura por ID
    @GetMapping("/{id}")
    public InvoiceOrderDTO getOrderById(@PathVariable Integer id) {
        return invoiceOrderService.getOrderById(id);
    }

    // Actualizar una factura
    @PutMapping("/{id}")
    public InvoiceOrderDTO updateOrder(@PathVariable Integer id, @RequestBody InvoiceOrderDTO dto) {
        return invoiceOrderService.updateOrder(id, dto);
    }

    // Eliminar una factura
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        invoiceOrderService.deleteOrder(id);
    }

    // Procesar facturas (SP)
    @PostMapping("/process")
    public void processInvoiceOrders(@RequestParam int month, @RequestParam int year) {
        invoiceOrderService.processInvoiceOrders(month, year);
    }
}


