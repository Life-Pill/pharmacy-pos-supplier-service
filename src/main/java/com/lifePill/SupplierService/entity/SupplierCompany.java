package com.lifePill.SupplierService.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "supplier_company")
public class SupplierCompany extends BasedEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator= "native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "supplier_company_id")
    private long supplierCompanyId;
    @Column(name = "supplier_company_name")
    private String supplierCompanyName;
    @Column(name = "supplier_company_email")
    private String supplierCompanyEmail;
    @Column(name = "supplier_company_phone")
    private String supplierCompanyPhone;
    @Column(name = "supplier_company_address")
    private String supplierCompanyAddress;
    @Column(name = "supplier_company_description")
    private String supplierCompanyDescription;

    @OneToMany(mappedBy="supplierCompany")
    private Set<Suppliers> suppliers;

    //TODO


    public SupplierCompany(long supplierCompanyId, String supplierCompanyName, String supplierCompanyEmail, String supplierCompanyPhone, String supplierCompanyAddress, String supplierCompanyDescription) {
        this.supplierCompanyId = supplierCompanyId;
        this.supplierCompanyName = supplierCompanyName;
        this.supplierCompanyEmail = supplierCompanyEmail;
        this.supplierCompanyPhone = supplierCompanyPhone;
        this.supplierCompanyAddress = supplierCompanyAddress;
        this.supplierCompanyDescription = supplierCompanyDescription;
    }
}
