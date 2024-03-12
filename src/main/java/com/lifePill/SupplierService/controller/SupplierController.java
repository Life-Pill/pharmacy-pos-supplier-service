package com.lifePill.SupplierService.controller;

import com.lifePill.SupplierService.dto.SupplierDTO;
import com.lifePill.SupplierService.service.SupplierService;
import com.lifePill.SupplierService.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lifepill/v1/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping("/saved")
    public ResponseEntity<StandardResponse> saveSupplier(@RequestBody SupplierDTO supplierDTO){
        SupplierDTO saveSupplierDTO = supplierService.saveSupplier(supplierDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,  "Supplier Saved Successfully",saveSupplierDTO),
                HttpStatus.CREATED);
    }
    @GetMapping("get-supplier-By-Id/{supplierId}")
    public ResponseEntity<StandardResponse> getSupplierById(@PathVariable(value ="supplierId") Long supplierId){
        SupplierDTO supplierDTO = supplierService.getSupplierByCode(supplierId);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,supplierId + " Supplier get Successfully",supplierDTO),
                HttpStatus.CREATED);
    }

    @GetMapping(path="/get-all-supplier")
    public ResponseEntity<StandardResponse> getAllSupplier(){
        List<SupplierDTO> allSupplier = supplierService.getAllSupplier();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"SUCCESS", allSupplier),
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/delete-supplier/{id}")
    public ResponseEntity<StandardResponse> deleteSupplier(@PathVariable(value = "id") long supplierId){
        String deleted = supplierService.deleteSupplier(supplierId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"DELETED", deleted),
                HttpStatus.OK
        );
    }
    @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateSupplier(@RequestBody SupplierDTO supplierDTO){
        String message = supplierService.updateSupplier(supplierDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"UPDATED", message),
                HttpStatus.OK
        );
    }
}
