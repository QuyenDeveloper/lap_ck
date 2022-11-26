package com.example.lap_ck.vos;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class TruongUpdateVO extends TruongVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
