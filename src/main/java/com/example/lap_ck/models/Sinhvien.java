package com.example.lap_ck.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sinhvien")
public class Sinhvien implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "soCCCD", nullable = false)
    private String soCCCD;

    @Column(name = "hoTen", nullable = false)
    private String hoTen;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "soDT", nullable = false)
    private String soDT;

    @Column(name = "diaChi", nullable = false)
    private String diaChi;

}
