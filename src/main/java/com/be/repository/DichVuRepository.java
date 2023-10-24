package com.be.repository;

import com.be.common_api.DichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DichVuRepository extends JpaRepository<DichVu, Long>, JpaSpecificationExecutor<DichVu> {
}