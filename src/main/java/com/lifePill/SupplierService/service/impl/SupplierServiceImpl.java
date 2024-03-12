package com.lifePill.SupplierService.service.impl;

import com.lifePill.SupplierService.dto.SupplierDTO;
import com.lifePill.SupplierService.entity.Suppliers;
import com.lifePill.SupplierService.exception.EntityDuplicationException;
import com.lifePill.SupplierService.exception.NotFoundException;
import com.lifePill.SupplierService.repository.SupplierRepository;
import com.lifePill.SupplierService.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository supplierRepository;

    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        if (supplierRepository.existsById(supplierDTO.getSupplierId()) ||
                supplierRepository.existsBySupplierEmail(supplierDTO.getSupplierEmail())) {
            throw new EntityDuplicationException("Supplier Company already exists");
        } else {
            Suppliers supplier = new Suppliers(
                    supplierDTO.getSupplierId(),
                    supplierDTO.getSupplierName(),
                    supplierDTO.getSupplierPhone(),
                    supplierDTO.getSupplierEmail(),
                    supplierDTO.getSupplierDescription()

            );
            Suppliers saveSupplier = supplierRepository.save(supplier);
            SupplierDTO savedSupplierDTO = new SupplierDTO(
                    saveSupplier.getSupplierId(),
                    saveSupplier.getSupplierName(),
                    saveSupplier.getSupplierPhone(),
                    saveSupplier.getSupplierEmail(),
                    saveSupplier.getSupplierDescription()
            );
            return savedSupplierDTO;
        }
    }

    @Override
    public SupplierDTO getSupplierByCode(Long supplierId) {
        Suppliers supplier = supplierRepository.findBySupplierId(supplierId);
        SupplierDTO supplierDTO = new SupplierDTO(
                supplier.getSupplierId(),
                supplier.getSupplierName(),
                supplier.getSupplierPhone(),
                supplier.getSupplierEmail(),
                supplier.getSupplierDescription()
        );
        return supplierDTO;
    }

    @Override
    public List<SupplierDTO> getAllSupplier() {
        List<Suppliers> getAllSupplier = supplierRepository.findAll();

        if (!getAllSupplier.isEmpty()) {
            List<SupplierDTO> supplierDTOList = new ArrayList<>();
            for (Suppliers supplier : getAllSupplier) {
                SupplierDTO supplierDTO = new SupplierDTO(
                        supplier.getSupplierId(),
                        supplier.getSupplierName(),
                        supplier.getSupplierPhone(),
                        supplier.getSupplierEmail(),
                        supplier.getSupplierDescription()
                );
                supplierDTOList.add(supplierDTO);
            }
            return supplierDTOList;
        } else {
            throw new NotFoundException("No Suppliers Found");
        }
    }

    @Override
    public String deleteSupplier(long supplierId) {
        if (supplierRepository.existsById(supplierId)){
            supplierRepository.deleteById(supplierId);

            return "deleted succesfully : "+ supplierId;
        }else {
            throw new NotFoundException("No Supplier found for that id");
        }
    }

    @Override
    public String updateSupplier(SupplierDTO supplierDTO) {
        if (supplierRepository.existsById(supplierDTO.getSupplierId())){
            Suppliers suppliers = supplierRepository.getReferenceById(supplierDTO.getSupplierId());
            suppliers.setSupplierName(supplierDTO.getSupplierName());
            suppliers.setSupplierPhone(supplierDTO.getSupplierPhone());
            suppliers.setSupplierEmail(supplierDTO.getSupplierEmail());
            suppliers.setSupplierDescription(supplierDTO.getSupplierDescription());

            supplierRepository.save(suppliers);

            System.out.println(suppliers);

            return "UPDATED SUPPLIER";
        }else {
            throw new NotFoundException("No data found for that id");
        }
    }
}
