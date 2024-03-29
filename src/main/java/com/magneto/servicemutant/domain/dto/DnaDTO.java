package com.magneto.servicemutant.domain.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class DnaDTO implements Serializable {

    private String[] value;
    private boolean isMutant;

}
