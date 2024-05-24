package com.lifePill.SupplierService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface SupplierRepository extends JpaRepository<Suppliers,Long> {
    boolean existsBySupplierEmail(String supplierEmail);

    Suppliers findBySupplierId(Long supplierId);
}
