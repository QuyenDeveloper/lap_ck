package com.example.lap_ck.vos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class NganhVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "maNganh can not null")
    private String maNganh;

    @NotNull(message = "tenNganh can not null")
    private String tenNganh;

    @NotNull(message = "loaiNganh can not null")
    private String loaiNganh;

}
