package com.be.repository;

import com.be.common_api.VatChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VatChatRepository extends JpaRepository<VatChat, Long>, JpaSpecificationExecutor<VatChat> {
}