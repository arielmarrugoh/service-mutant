package com.magneto.servicemutant.validator.internal;

import com.magneto.servicemutant.domain.dto.ResultValidate;
import com.magneto.servicemutant.validator.ValidationProvider;
import com.magneto.servicemutant.validator.ValidationStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultValidationProvider implements ValidationProvider {

    public ResultValidate validate(String[] dnas) {
        List<ValidationStrategy> conditions = new ArrayList<>();
        ResultValidate resultValidateTotal = new ResultValidate();
        resultValidateTotal.setValid(true);

        conditions.add(new DnaLettersValidation());
        conditions.add(new HorizontalSequenceValidation());
        conditions.add(new VerticalSequenceValidation());
        conditions.add(new DiagonalSequenceValidation());
        conditions.add(new ReverseDiagonalSequenceValidation());
        for (final ValidationStrategy validationStrategy : conditions) {
            final ResultValidate resultValidate = validationStrategy.validate(dnas);
            if (!resultValidate.isValid()) {
                resultValidateTotal.setValid(resultValidate.isValid());
                resultValidateTotal.setMessage(resultValidate.getMessage());
                resultValidateTotal.setSequenceCount(resultValidate.getSequenceCount());
                return resultValidateTotal;
            }
            resultValidateTotal.setSequenceCount(resultValidateTotal.getSequenceCount()+
                    resultValidate.getSequenceCount());
        }

        return resultValidateTotal;
    }
}
