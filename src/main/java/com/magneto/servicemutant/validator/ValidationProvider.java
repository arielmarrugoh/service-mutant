package com.magneto.servicemutant.validator;

import com.magneto.servicemutant.domain.dto.ResultValidate;

public interface ValidationProvider {
    public ResultValidate validate(String[] dna);
}
