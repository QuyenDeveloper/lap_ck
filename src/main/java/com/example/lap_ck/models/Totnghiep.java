package com.example.lap_ck.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "totnghiep")
@IdClass(Totnghiep.class)
public class Totnghiep implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "soCCCD", nullable = false)
    private String soCCCD;

    @Id
    @Column(name = "maTruong", nullable = false)
    private String maTruong;

    @Id
    @Column(name = "maNganh", nullable = false)
    private String maNganh;

    @Column(name = "heTN", nullable = false)
    private String heTN;

    @Column(name = "ngayTN", nullable = false)
    private Date ngayTN;

    @Column(name = "loaiTN", nullable = false)
    private String loaiTN;

}
