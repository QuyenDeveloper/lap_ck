package com.example.lap_ck.vos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;


@Data
public class CongviecVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "soCCCD can not null")
    private String soCCCD;

    @NotNull(message = "ngayVaoCongTy can not null")
    private Date ngayVaoCongTy;

    @NotNull(message = "maNganh can not null")
    private String maNganh;

    @NotNull(message = "tenCongViec can not null")
    private String tenCongViec;

    @NotNull(message = "tenCongTy can not null")
    private String tenCongTy;

    @NotNull(message = "diaChiCongTy can not null")
    private String diaChiCongTy;

    @NotNull(message = "thoiGianLamViec can not null")
    private String thoiGianLamViec;

}
