package com.example.lap_ck.vos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class SinhvienVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "soCCCD can not null")
    private String soCCCD;

    @NotNull(message = "hoTen can not null")
    private String hoTen;

    @NotNull(message = "email can not null")
    private String email;

    @NotNull(message = "soDT can not null")
    private String soDT;

    @NotNull(message = "diaChi can not null")
    private String diaChi;

}
