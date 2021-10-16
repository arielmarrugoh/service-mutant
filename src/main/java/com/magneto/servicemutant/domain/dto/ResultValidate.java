package com.magneto.servicemutant.domain.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class ResultValidate implements Serializable {
    private boolean valid;
    private String message;
    private int sequenceCount;
}
