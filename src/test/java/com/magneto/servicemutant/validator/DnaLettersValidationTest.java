package com.magneto.servicemutant.validator;

import com.magneto.servicemutant.domain.dto.ResultValidate;
import com.magneto.servicemutant.validator.internal.DnaLettersValidation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = {DnaLettersValidation.class})
public class DnaLettersValidationTest {

    @InjectMocks
    private DnaLettersValidation dnaLettersValidation;
    private final String[] mutantDna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
    //private final String[] invalidDna = {"TTGCGA", "TGXCGA"};
    private final String[] invalidDna = {"CAGA","CCTG","CCAT","AGCT","CTC5"};
    private ResultValidate invalidDnaResult;
    private ResultValidate validDnaResult;

    @Before
    public void setUp(){
        invalidDnaResult = new ResultValidate();
        invalidDnaResult.setValid(false);

        validDnaResult = new ResultValidate();
        validDnaResult.setValid(true);
    }

    @Test
    public void nullDna(){
        ResultValidate resultValidate = this.dnaLettersValidation.validate(null);
        Assert.assertEquals(invalidDnaResult, resultValidate);
    }

    @Test
    public void IsEmptyDna(){
        String[] isEmptydna = new String[0];
        ResultValidate resultValidate = this.dnaLettersValidation.validate(isEmptydna);
        Assert.assertEquals(invalidDnaResult, resultValidate);
    }

    @Test
    public void ValidDna(){
        ResultValidate resultValidate = this.dnaLettersValidation.validate(mutantDna);
        Assert.assertEquals(validDnaResult, resultValidate);
    }

    @Test
    public void invalidCharacterDna(){
        ResultValidate resultValidate = this.dnaLettersValidation.validate(invalidDna);
        Assert.assertEquals(invalidDnaResult, resultValidate);
    }
}
