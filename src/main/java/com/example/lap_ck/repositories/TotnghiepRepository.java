package com.example.lap_ck.repositories;

import com.example.lap_ck.models.Totnghiep;
import com.example.lap_ck.vos.TotnghiepVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Repository
@Transactional
public interface TotnghiepRepository extends JpaRepository<Totnghiep, String>, JpaSpecificationExecutor<Totnghiep> {

    @Modifying
    @Query("DELETE FROM Totnghiep t where t.soCCCD = :id and t.maTruong = :mt and t.maNganh = :mn")
    void deleteQR(@Param("id") String id,
                  @Param("mt") String mt,
                  @Param("mn") String mn);

    @Query("SELECT q FROM Totnghiep q where q.soCCCD = :id and q.maTruong = :mt and q.maNganh = :mn")
    Totnghiep editQRPre(@Param("id") String id,
                        @Param("mt") String mt,
                        @Param("mn") String mn);

    @Modifying
    @Query("UPDATE Totnghiep q SET q.maNganh = :mn, q.maTruong = :mt, q.heTN = :heTN, q.loaiTN = :loaiTN, q.ngayTN = :ngayTN where q.soCCCD = :idss and q.maTruong = :mtss and q.maNganh = :mnss")
    void editQRPost(@Param("idss") String idss,
                    @Param("mtss") String mtss,
                    @Param("mnss") String mnss,
                    @Param("id") String id,
                    @Param("mt") String mt,
                    @Param("mn") String mn,
                    @Param("heTN") String heTN,
                    @Param("loaiTN") String loaiTN,
                    @Param("ngayTN")Date ngayTN);
}