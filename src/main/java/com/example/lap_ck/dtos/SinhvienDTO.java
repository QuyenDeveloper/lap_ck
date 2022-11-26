package com.example.lap_ck.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class SinhvienDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String soCCCD;

    private String hoTen;

    private String email;

    private String soDT;

    private String diaChi;

}
