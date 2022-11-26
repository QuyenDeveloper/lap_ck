package com.example.lap_ck.vos;


import lombok.Data;

import java.io.Serializable;

@Data
public class TruongQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String maTruong;

    private String tenTruong;

    private String diaChi;

    private String soDT;

}
