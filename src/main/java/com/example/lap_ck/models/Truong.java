package com.example.lap_ck.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "truong")
public class Truong implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "maTruong", nullable = false)
    private String maTruong;

    @Column(name = "tenTruong", nullable = false)
    private String tenTruong;

    @Column(name = "diaChi", nullable = false)
    private String diaChi;

    @Column(name = "soDT", nullable = false)
    private String soDT;

}
