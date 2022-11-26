package com.example.lap_ck.repositories;

import com.example.lap_ck.models.Congviec;
import com.example.lap_ck.models.Sinhvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IndexRepository extends JpaRepository<Sinhvien, String>, JpaSpecificationExecutor<Sinhvien> {
    @Query("SELECT q FROM Sinhvien q where q.soCCCD = :id")
    List<Sinhvien> timKiemQR(@Param("id") String id);
}
