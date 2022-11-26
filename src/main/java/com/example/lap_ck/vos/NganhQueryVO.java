package com.example.lap_ck.vos;


import lombok.Data;

import java.io.Serializable;

@Data
public class NganhQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String maNganh;

    private String tenNganh;

    private String loaiNganh;

}
