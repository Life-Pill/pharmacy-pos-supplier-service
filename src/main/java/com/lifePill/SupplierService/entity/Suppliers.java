package com.lifePill.SupplierService.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supplier")
@Builder
public class Suppliers extends BasedEntity{
    @Id
    @Column(name = "supplier_id")
    @GeneratedValue(strategy = GenerationType.AUTO,generator= "native")
    @GenericGenerator(name = "native",strategy = "native")
    private long supplierId;
    @Column(name = "supplier_name")
    private String supplierName;
    @Column(name = "supplier_phone")
    private String supplierPhone;
    @Column(name = "supplier_email")
    private String supplierEmail;
    @Column(name = "supplier_description")
    private String supplierDescription;

    @ManyToOne
    @JoinColumn(name="supplier_company_id", nullable=false)
    private SupplierCompany supplierCompany;
}
