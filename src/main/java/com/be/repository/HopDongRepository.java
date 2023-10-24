package com.be.repository;

import com.be.common_api.HopDong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface HopDongRepository extends JpaRepository<HopDong, Long>, JpaSpecificationExecutor<HopDong> {
}