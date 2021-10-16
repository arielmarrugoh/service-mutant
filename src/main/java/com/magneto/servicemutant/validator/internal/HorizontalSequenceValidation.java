package com.magneto.servicemutant.validator.internal;

import com.magneto.servicemutant.domain.dto.ResultValidate;
import com.magneto.servicemutant.util.NitrogenousBaseConstant;
import com.magneto.servicemutant.validator.ValidationStrategy;
import org.springframework.stereotype.Service;

@Service
public class HorizontalSequenceValidation implements ValidationStrategy {

    @Override
    public ResultValidate validate(String[] dnas) {
        ResultValidate resultValidate = new ResultValidate();
        resultValidate.setValid(true);
        for (String dna : dnas) {
            resultValidate = sequenceCountDna(dna, resultValidate);
        }

        return resultValidate;
    }


    private static ResultValidate sequenceCountDna(String dna, ResultValidate resultValidate) {

        if(dna.contains(NitrogenousBaseConstant.ADENINE_SEQUENCE)){
            resultValidate.setSequenceCount(resultValidate.getSequenceCount()+1);
        }

        if(dna.contains(NitrogenousBaseConstant.THYMINE_SEQUENCE)){
            resultValidate.setSequenceCount(resultValidate.getSequenceCount()+1);
        }

        if(dna.contains(NitrogenousBaseConstant.CYTOSINE_SEQUENCE)){
            resultValidate.setSequenceCount(resultValidate.getSequenceCount()+1);
        }

        if(dna.contains(NitrogenousBaseConstant.GUANINE_SEQUENCE)){
            resultValidate.setSequenceCount(resultValidate.getSequenceCount()+1);
        }
        return resultValidate;

    }
}
