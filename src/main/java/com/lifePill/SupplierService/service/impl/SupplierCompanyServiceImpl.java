package com.lifePill.SupplierService.service.impl;

import com.lifePill.SupplierService.dto.SupplierCompanyDTO;
import com.lifePill.SupplierService.entity.SupplierCompany;
import com.lifePill.SupplierService.exception.EntityDuplicationException;
import com.lifePill.SupplierService.exception.NotFoundException;
import com.lifePill.SupplierService.repository.SupplierCompanyRepository;
import com.lifePill.SupplierService.repository.SupplierRepository;
import com.lifePill.SupplierService.service.SupplierCompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SupplierCompanyServiceImpl implements SupplierCompanyService {


    private SupplierCompanyRepository supplierCompanyRepository;

    @Override
    public SupplierCompanyDTO saveSupplierCompany(SupplierCompanyDTO supplierCompanyDTO) {
        if (supplierCompanyRepository.existsById(supplierCompanyDTO.getSupplierCompanyId()) ||
                supplierCompanyRepository.existsBySupplierCompanyEmail(supplierCompanyDTO.getSupplierCompanyEmail())) {
            throw new EntityDuplicationException("Supplier Company already exists");
        } else {
            SupplierCompany supplierCompany = new SupplierCompany(
                    supplierCompanyDTO.getSupplierCompanyId(),
                    supplierCompanyDTO.getSupplierCompanyName(),
                    supplierCompanyDTO.getSupplierCompanyEmail(),
                    supplierCompanyDTO.getSupplierCompanyPhone(),
                    supplierCompanyDTO.getSupplierCompanyAddress(),
                    supplierCompanyDTO.getSupplierCompanyDescription()
            );
            SupplierCompany saveSupplierCompany = supplierCompanyRepository.save(supplierCompany);
            SupplierCompanyDTO savedSupplierCompanyDTO = new SupplierCompanyDTO(
                    saveSupplierCompany.getSupplierCompanyId(),
                    saveSupplierCompany.getSupplierCompanyName(),
                    saveSupplierCompany.getSupplierCompanyEmail(),
                    saveSupplierCompany.getSupplierCompanyPhone(),
                    saveSupplierCompany.getSupplierCompanyAddress(),
                    saveSupplierCompany.getSupplierCompanyDescription()
            );
            return savedSupplierCompanyDTO;
        }
    }

    @Override
    public SupplierCompanyDTO getSupplierByCode(Long supplierCompanyId) {
        SupplierCompany supplierCompany = supplierCompanyRepository.findBySupplierCompanyId(supplierCompanyId);
        SupplierCompanyDTO supplierCompanyDTO = new SupplierCompanyDTO(
                supplierCompany.getSupplierCompanyId(),
                supplierCompany.getSupplierCompanyName(),
                supplierCompany.getSupplierCompanyEmail(),
                supplierCompany.getSupplierCompanyPhone(),
                supplierCompany.getSupplierCompanyAddress(),
                supplierCompany.getSupplierCompanyDescription()
        );
        return supplierCompanyDTO;
    }

    @Override
    public List<SupplierCompanyDTO> getAllSupplierCompany() {
        List<SupplierCompany> getAllSupplierCompany = supplierCompanyRepository.findAll();

        if (!getAllSupplierCompany.isEmpty()) {
            List<SupplierCompanyDTO> supplierCompanyDTOList = new ArrayList<>();
            for (SupplierCompany supplierCompany : getAllSupplierCompany) {
                SupplierCompanyDTO supplierCompanyDTO = new SupplierCompanyDTO(
                        supplierCompany.getSupplierCompanyId(),
                        supplierCompany.getSupplierCompanyName(),
                        supplierCompany.getSupplierCompanyPhone(),
                        supplierCompany.getSupplierCompanyAddress(),
                        supplierCompany.getSupplierCompanyEmail(),
                        supplierCompany.getSupplierCompanyDescription()
                );
                supplierCompanyDTOList.add(supplierCompanyDTO);
            }
            return supplierCompanyDTOList;
        } else {
            throw new NotFoundException("No Supplier Company Found");
        }
    }
    @Override
    public String deleteSupplierCompany(long supplierCompanyId) {
        if (supplierCompanyRepository.existsById(supplierCompanyId)){
            supplierCompanyRepository.deleteById(supplierCompanyId);

            return "deleted succesfully : "+ supplierCompanyId;
        }else {
            throw new NotFoundException("No Supplier Company found for that id");
        }
    }

    @Override
    public String updateSupplierCompany(SupplierCompanyDTO supplierCompanyDTO) {
        if (supplierCompanyRepository.existsById(supplierCompanyDTO.getSupplierCompanyId())){
            SupplierCompany supplierCompany = supplierCompanyRepository.getReferenceById(supplierCompanyDTO.getSupplierCompanyId());
            supplierCompany.setSupplierCompanyName(supplierCompanyDTO.getSupplierCompanyName());
            supplierCompany.setSupplierCompanyEmail(supplierCompanyDTO.getSupplierCompanyEmail());
            supplierCompany.setSupplierCompanyPhone(supplierCompanyDTO.getSupplierCompanyPhone());
            supplierCompany.setSupplierCompanyAddress(supplierCompanyDTO.getSupplierCompanyAddress());
            supplierCompany.setSupplierCompanyDescription(supplierCompanyDTO.getSupplierCompanyDescription());

            supplierCompanyRepository.save(supplierCompany);

            System.out.println(supplierCompany);

            return "UPDATED SUPPLIER COMPANY";
        }else {
            throw new NotFoundException("No data found for that id");
        }
    }


}