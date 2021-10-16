package com.magneto.servicemutant.validator;

import com.magneto.servicemutant.domain.dto.ResultValidate;
import com.magneto.servicemutant.validator.internal.DefaultValidationProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = {DefaultValidationProvider.class})
public class DefaultValidationProviderTest {

    @InjectMocks
    private DefaultValidationProvider defaultValidationProvider;
    private final String[] invalidDna = {"TTGCGA", "TGXCGA"};
    private ResultValidate invalidDnaResult;
    private final String[] validSequenceDna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
    private ResultValidate horizontalSequenceResultValidate;

    @Before
    public void setUp(){
        invalidDnaResult = new ResultValidate();
        invalidDnaResult.setValid(false);

        horizontalSequenceResultValidate = new ResultValidate();
        horizontalSequenceResultValidate.setValid(true);
        horizontalSequenceResultValidate.setSequenceCount(3);

    }

    @Test
    public void invalidDna(){
        ResultValidate resultValidate = this.defaultValidationProvider.validate(invalidDna);
        Assert.assertEquals(invalidDnaResult, resultValidate);
    }

    @Test
    public void validSecuenceDna(){
        ResultValidate resultValidate = this.defaultValidationProvider.validate(validSequenceDna);
        Assert.assertEquals(horizontalSequenceResultValidate, resultValidate);
    }
}
