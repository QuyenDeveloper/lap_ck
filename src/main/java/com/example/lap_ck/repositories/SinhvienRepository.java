package com.example.lap_ck.repositories;

import com.example.lap_ck.models.Sinhvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SinhvienRepository extends JpaRepository<Sinhvien, String>, JpaSpecificationExecutor<Sinhvien> {

}