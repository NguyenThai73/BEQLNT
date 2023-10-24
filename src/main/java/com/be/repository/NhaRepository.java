package com.be.repository;

import com.be.common_api.Nha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaRepository extends JpaRepository<Nha, Long>, JpaSpecificationExecutor<Nha> {
}