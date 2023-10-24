package com.be.repository;

import com.be.common_api.Phong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongRepository extends JpaRepository<Phong, Long>, JpaSpecificationExecutor<Phong> {
}