package com.example.lap_ck.dtos;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class CongviecDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String soCCCD;

    private Date ngayVaoCongTy;

    private String maNganh;

    private String tenCongViec;

    private String tenCongTy;

    private String diaChiCongTy;

    private String thoiGianLamViec;

}
