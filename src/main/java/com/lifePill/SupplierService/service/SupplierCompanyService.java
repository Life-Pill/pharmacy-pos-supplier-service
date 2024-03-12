package com.lifePill.SupplierService.service;

import com.lifePill.SupplierService.dto.SupplierCompanyDTO;

import java.util.List;

public interface SupplierCompanyService {
//    public String saveSupplierCompany(SupplierCompanyDTO supplierCompanyDTO);

    SupplierCompanyDTO saveSupplierCompany(SupplierCompanyDTO supplierCompanyDTO);

    SupplierCompanyDTO getSupplierByCode(Long supplierCompanyId);

    List<SupplierCompanyDTO> getAllSupplierCompany();

    String deleteSupplierCompany(long supplierCompanyId);

    String updateSupplierCompany(SupplierCompanyDTO supplierCompanyDTO);
}