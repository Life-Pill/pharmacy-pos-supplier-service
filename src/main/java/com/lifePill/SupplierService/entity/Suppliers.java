package com.lifePill.SupplierService.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supplier")
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
    @JoinColumn(name="supplier_company_id")
    private SupplierCompany supplierCompany;

    //TODO
//    @OneToMany(mappedBy="suppliers")
//    private Set<SupplierPurchaseReturn> supplierPurchaseReturns;

//    @ManyToOne
//    @JoinColumn(name="supplier_company_id", nullable=false)
//    private SupplierCompany supplierCompany;


    public Suppliers(long supplierId, String supplierName, String supplierPhone, String supplierEmail, String supplierDescription) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierPhone = supplierPhone;
        this.supplierEmail = supplierEmail;
        this.supplierDescription = supplierDescription;
    }

    public Suppliers(String supplierName, String supplierPhone, String supplierEmail, String supplierDescription) {
        this.supplierName = supplierName;
        this.supplierPhone = supplierPhone;
        this.supplierEmail = supplierEmail;
        this.supplierDescription = supplierDescription;
    }
}
