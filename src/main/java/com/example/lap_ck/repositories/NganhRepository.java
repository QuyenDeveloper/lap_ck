package com.example.lap_ck.repositories;

import com.example.lap_ck.models.Nganh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NganhRepository extends JpaRepository<Nganh, String>, JpaSpecificationExecutor<Nganh> {

}