package com.example.lap_ck.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Persistable;

@Data
@Entity
@Table(name = "congviec")
@IdClass(Congviec.class)
public class Congviec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "soCCCD", nullable = false)
    private String soCCCD;

    @Id
    @Column(name = "ngayVaoCongTy", nullable = false)
    private Date ngayVaoCongTy;

    @Id
    @Column(name = "maNganh", nullable = false)
    private String maNganh;

    @Column(name = "tenCongViec", nullable = false)
    private String tenCongViec;

    @Column(name = "tenCongTy", nullable = false)
    private String tenCongTy;

    @Column(name = "diaChiCongTy", nullable = false)
    private String diaChiCongTy;

    @Column(name = "thoiGianLamViec", nullable = false)
    private String thoiGianLamViec;


}
