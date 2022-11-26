package com.example.lap_ck.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "nganh")
public class Nganh implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "maNganh", nullable = false)
    private String maNganh;

    @Column(name = "tenNganh", nullable = false)
    private String tenNganh;

    @Column(name = "loaiNganh", nullable = false)
    private String loaiNganh;

}
