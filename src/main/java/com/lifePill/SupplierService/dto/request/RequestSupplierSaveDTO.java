package com.lifePill.SupplierService.dto.request;

import com.lifePill.SupplierService.entity.SupplierCompany;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestSupplierSaveDTO {

   // private long supplierId;

   private long supplierCompanyID;
    private String supplierName;
    private String supplierPhone;
    private String supplierEmail;
    private String supplierDescription;

    //TODO
    //private List<SupplierProductDetails> supplierProductDetails;
}
