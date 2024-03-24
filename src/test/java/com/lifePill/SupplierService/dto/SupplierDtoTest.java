package com.lifePill.SupplierService.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupplierDtoTest {
    @Test
    public void testSupplierDTOConstruction() {
        SupplierDTO supplierDTO = new SupplierDTO(1L, "Test Supplier", "1234567890", "test@example.com", "Supplier description");

        assertEquals(1L, supplierDTO.getSupplierId());
        assertEquals("Test Supplier", supplierDTO.getSupplierName());
        assertEquals("1234567890", supplierDTO.getSupplierPhone());
        assertEquals("test@example.com", supplierDTO.getSupplierEmail());
        assertEquals("Supplier description", supplierDTO.getSupplierDescription());
    }
}
