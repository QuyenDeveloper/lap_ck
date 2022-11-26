package com.example.lap_ck.vos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;


@Data
public class TotnghiepVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "soCCCD can not null")
    private String soCCCD;

    @NotNull(message = "maTruong can not null")
    private String maTruong;

    @NotNull(message = "maNganh can not null")
    private String maNganh;

    @NotNull(message = "heTN can not null")
    private String heTN;

    @NotNull(message = "ngayTN can not null")
    private Date ngayTN;

    @NotNull(message = "loaiTN can not null")
    private String loaiTN;

}
