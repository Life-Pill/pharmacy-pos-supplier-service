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
    private long SupllierCompanyId;
    @Column(name = "supplier_company_name")
    private String SupplierCompanyName;
    @Column(name = "supplier_company_email")
    private String SupplierCompanyEmail;
    @Column(name = "supplier_company_phone")
    private String SupplierCompanyPhone;
    @Column(name = "supplier_company_address")
    private String SupplierCompanyAddress;
    @Column(name = "supplier_company_description")
    private String SupplierCompanyDescription;

    @OneToMany(mappedBy="supplierCompany")
    private Set<Suppliers> suppliers;

}
