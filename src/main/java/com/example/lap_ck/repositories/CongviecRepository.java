package com.example.lap_ck.repositories;

import com.example.lap_ck.models.Congviec;
import com.example.lap_ck.models.Totnghiep;
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
public interface CongviecRepository extends JpaRepository<Congviec, String>, JpaSpecificationExecutor<Congviec> {

    @Modifying
    @Query("DELETE FROM Congviec t where t.soCCCD = :id and t.ngayVaoCongTy = :ngay and t.maNganh = :mn")
    void deleteQR(@Param("id") String id,
                  @Param("ngay")Date ngay,
                  @Param("mn") String mn);

    @Query("SELECT q FROM Congviec q where q.soCCCD = :id and q.ngayVaoCongTy = :ngay and q.maNganh = :mn")
    Congviec editQRPre(@Param("id") String id,
                        @Param("ngay") Date ngay,
                        @Param("mn") String mn);
    @Modifying
    @Query("UPDATE Congviec q set q.maNganh = :mn,q.diaChiCongTy=:diachi,q.tenCongTy=:tct,q.tenCongViec=:tcv,q.thoiGianLamViec=:thoigian where q.soCCCD = :idss and q.ngayVaoCongTy = :ngayss and q.maNganh = :mnss")
    void editQRPost(@Param("idss") String idss,
                    @Param("ngayss") Date ngayss,
                    @Param("mnss") String mnss,
                    @Param("ngay") Date ngay,
                    @Param("mn") String mn,
                    @Param("tcv") String tcv,
                    @Param("tct") String tct,
                    @Param("diachi") String diachi,
                    @Param("thoigian") String thoigian);
}