package com.example.lap_ck.vos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class TruongVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "maTruong can not null")
    private String maTruong;

    @NotNull(message = "tenTruong can not null")
    private String tenTruong;

    @NotNull(message = "diaChi can not null")
    private String diaChi;

    @NotNull(message = "soDT can not null")
    private String soDT;

}
