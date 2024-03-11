package com.lifePill.SupplierService.controller;

import com.lifePill.SupplierService.dto.SupplierCompanyDTO;
import com.lifePill.SupplierService.dto.SupplierDTO;
import com.lifePill.SupplierService.service.SupplierCompanyService;
import com.lifePill.SupplierService.service.SupplierService;
import com.lifePill.SupplierService.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lifepill/v1/supplier")
public class SupplierController {

    @Autowired
    private SupplierCompanyService supplierCompanyService;

    @PostMapping("/saved")
    public ResponseEntity<StandardResponse> saveSupplierCompany(@RequestBody SupplierCompanyDTO supplierCompanyDTO){
        SupplierCompanyDTO saveSupplierCompany = supplierCompanyService.saveSupplierCompany(supplierCompanyDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,  "Supplier Saved Successfully",saveSupplierCompany),
                HttpStatus.CREATED);
    }
    @GetMapping("get-supplier-Company-By-Id/{supplierCompanyId}")
    public ResponseEntity<StandardResponse> getSupplierCompanyById(@PathVariable(value ="supplierCompanyId") Long supplierCompanyId){
        SupplierCompanyDTO supplierCompanyDTO = supplierCompanyService.getSupplierByCode(supplierCompanyId);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,supplierCompanyId + " Supplier company get Successfully",supplierCompanyDTO),
                HttpStatus.CREATED);
    }

    @GetMapping(path="/get-all-supplierCompany")
    public ResponseEntity<StandardResponse> getAllSupplierCompany(){
        List<SupplierCompanyDTO> allSupplierCompany = supplierCompanyService.getAllSupplierCompany();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"SUCCESS", allSupplierCompany),
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/delete-supplierCompany/{id}")
    public ResponseEntity<StandardResponse> deleteSupplierCompany(@PathVariable(value = "id") long supplierCompanyId){
        String deleted = supplierCompanyService.deleteSupplierCompany(supplierCompanyId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"DELETED", deleted),
                HttpStatus.OK
        );
    }
    @PutMapping("/update")
    public String updateSupplierCompany(@RequestBody SupplierCompanyDTO supplierCompanyDTO){
        String message = supplierCompanyService.updateSupplierCompany(supplierCompanyDTO);
        return message;
    }

}
