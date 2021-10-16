package com.magneto.servicemutant.validator.internal;

import com.magneto.servicemutant.domain.dto.ResultValidate;
import com.magneto.servicemutant.util.MatrizUtil;
import com.magneto.servicemutant.util.NitrogenousBaseConstant;
import com.magneto.servicemutant.validator.ValidationStrategy;
import org.springframework.stereotype.Service;

@Service
public class DiagonalSequenceValidation implements ValidationStrategy {

    @Override
    public ResultValidate validate(String[] dnas) {
        ResultValidate resultValidate = new ResultValidate();
        resultValidate.setValid(true);
        char[][] matrizChar=MatrizUtil.matrizDna(dnas);
        final int columnsSize = MatrizUtil.columns(dnas);
        int rowsSize = dnas.length;


        resultValidate = diagonalSequenceValidationDesc(resultValidate, matrizChar, columnsSize, rowsSize);
        resultValidate = diagonalSequenceValidationAsc(resultValidate, matrizChar, columnsSize, rowsSize);

        return resultValidate;
    }

    private ResultValidate diagonalSequenceValidationDesc(ResultValidate resultValidate,
                                             char[][] matrizChar,
                                             int columnsSize,
                                             int rowsSize) {
        for(int rowIterar = 0; rowIterar< rowsSize; rowIterar++){
            StringBuilder sequenceVertical = new StringBuilder();
            for (int j = 0, i = rowIterar; j < columnsSize && i< rowsSize; i++,j++) {
                sequenceVertical.append(matrizChar[i][j]);

            }
            resultValidate = sequenceCountDna(sequenceVertical.toString(), resultValidate);
        }
        return resultValidate;
    }

    private ResultValidate diagonalSequenceValidationAsc(ResultValidate resultValidate,
                                                          char[][] matrizChar,
                                                          int columnsSize,
                                                          int rowsSize) {
        for(int columsIterar = 1; columsIterar< columnsSize; columsIterar++){
            StringBuilder sequenceVertical = new StringBuilder();
            for (int j = columsIterar, i = 0; j < columnsSize && i< rowsSize; i++,j++) {
                sequenceVertical.append(matrizChar[i][j]);

            }
            resultValidate = sequenceCountDna(sequenceVertical.toString(), resultValidate);
        }
        return resultValidate;
    }


    private static ResultValidate sequenceCountDna(String sequenceVertical, ResultValidate resultValidate) {

        if(sequenceVertical.contains(NitrogenousBaseConstant.ADENINE_SEQUENCE)){
            resultValidate.setSequenceCount(resultValidate.getSequenceCount()+1);
        }

        if(sequenceVertical.contains(NitrogenousBaseConstant.THYMINE_SEQUENCE)){
            resultValidate.setSequenceCount(resultValidate.getSequenceCount()+1);
        }

        if(sequenceVertical.contains(NitrogenousBaseConstant.CYTOSINE_SEQUENCE)){
            resultValidate.setSequenceCount(resultValidate.getSequenceCount()+1);
        }

        if(sequenceVertical.contains(NitrogenousBaseConstant.GUANINE_SEQUENCE)){
            resultValidate.setSequenceCount(resultValidate.getSequenceCount()+1);
        }
        return resultValidate;

    }
}
