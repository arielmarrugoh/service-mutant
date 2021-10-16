package com.magneto.servicemutant.validator.internal;

import com.magneto.servicemutant.domain.dto.ResultValidate;
import com.magneto.servicemutant.util.NitrogenousBaseConstant;
import com.magneto.servicemutant.validator.ValidationStrategy;
import org.springframework.stereotype.Service;

@Service
public class DnaLettersValidation implements ValidationStrategy {

    public DnaLettersValidation(){

    }
    @Override
    public ResultValidate validate(String[] dnas) {
        ResultValidate resultValidate=new ResultValidate();
        resultValidate.setValid(true);
        if( dnas == null ||
                dnas.length== 0){
            resultValidate.setValid(false);
            return resultValidate;

        }else {
            for (String dna : dnas) {
                if(!dnaSequenceValidate(dna)){
                    resultValidate.setValid(false);
                    return resultValidate;
                }

            }
        }

        return resultValidate;
    }


    private boolean dnaSequenceValidate(String dna){
        char[] dnaChars = dna.toCharArray();

        boolean resultDnaSequenceValidate= false;

        for (int i = 0; i < dnaChars.length; i++) {

            switch (dnaChars[i]){
                case NitrogenousBaseConstant.ADENINE_CODE:
                    resultDnaSequenceValidate = true;
                    break;
                case NitrogenousBaseConstant.CYTOSINE_CODE:
                    resultDnaSequenceValidate = true;
                    break;
                case NitrogenousBaseConstant.GUANINE_CODE:
                    resultDnaSequenceValidate = true;
                    break;
                case NitrogenousBaseConstant.THYMINE_CODE:
                    resultDnaSequenceValidate = true;
                    break;
                default:
                    return false;
            }
        }
        return resultDnaSequenceValidate;

    }
}
