package com.example.MyAdmin.repository;

import com.example.MyAdmin.model.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PartnerRepository extends JpaRepository<Partner,Long> {
}
