package com.lifePill.SupplierService.repository;

import com.lifePill.SupplierService.entity.SupplierCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierCompanyRepository extends JpaRepository<SupplierCompany, Long> {
    boolean existsBySupplierCompanyEmail(String supplierCompanyEmail);

    SupplierCompany findBySupplierCompanyId(Long supplierCompanyId);

}
