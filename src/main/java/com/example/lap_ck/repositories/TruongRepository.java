package com.example.lap_ck.repositories;

import com.example.lap_ck.models.Truong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TruongRepository extends JpaRepository<Truong, String>, JpaSpecificationExecutor<Truong> {

}