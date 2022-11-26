package com.example.lap_ck.dtos;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class TotnghiepDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String soCCCD;

    private String maTruong;

    private String maNganh;

    private String heTN;

    private Date ngayTN;

    private String loaiTN;

}
