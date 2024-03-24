package com.lifePill.SupplierService.service;

import com.lifePill.SupplierService.dto.SupplierCompanyDTO;
import com.lifePill.SupplierService.dto.SupplierDTO;
import com.lifePill.SupplierService.dto.request.RequestSupplierSaveDTO;

import java.util.List;

public interface SupplierService {

    SupplierDTO saveSupplier(SupplierDTO supplierDTO);

    SupplierDTO getSupplierByCode(Long supplierId);

    List<SupplierDTO> getAllSupplier();

    String deleteSupplier(long supplierId);

    String updateSupplier(SupplierDTO supplierDTO);

    String addSupplier(RequestSupplierSaveDTO requestSupplierSaveDTO);
}
