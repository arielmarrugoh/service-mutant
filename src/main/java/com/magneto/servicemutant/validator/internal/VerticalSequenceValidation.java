package com.magneto.servicemutant.validator.internal;

import com.magneto.servicemutant.domain.dto.ResultValidate;
import com.magneto.servicemutant.util.MatrizUtil;
import com.magneto.servicemutant.util.NitrogenousBaseConstant;
import com.magneto.servicemutant.validator.ValidationStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VerticalSequenceValidation implements ValidationStrategy {

    @Override
    public ResultValidate validate(String[] dnas) {
        ResultValidate resultValidate = new ResultValidate();
        resultValidate.setValid(true);
        char[][] matrizChar=MatrizUtil.matrizDna(dnas);
        final int columnsSize = MatrizUtil.columns(dnas);
        int rowsSize = dnas.length;


        for (int j = 0; j < columnsSize; j++) {
            StringBuilder sequenceVertical = new StringBuilder();
            for (int i = 0; i < rowsSize; i++) {
                try {
                    sequenceVertical.append(matrizChar[i][j]);
                }catch (Exception e){
                    log.info("Celda no existe");
                }

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
