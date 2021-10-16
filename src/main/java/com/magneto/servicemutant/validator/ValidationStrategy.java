package com.magneto.servicemutant.validator;

import com.magneto.servicemutant.domain.dto.ResultValidate;

public interface ValidationStrategy {
    ResultValidate validate(String[] dna);
}
