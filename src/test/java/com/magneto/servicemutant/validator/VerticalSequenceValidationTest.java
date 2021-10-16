package com.magneto.servicemutant.validator;

import com.magneto.servicemutant.domain.dto.ResultValidate;
import com.magneto.servicemutant.validator.internal.VerticalSequenceValidation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = {VerticalSequenceValidation.class})
public class VerticalSequenceValidationTest {

    @InjectMocks
    private VerticalSequenceValidation verticalSequenceValidation;
    private final String[] adenineSequenceDna = {"ATGCGA","AAGTGC","ATATGT","AGAATG","GAAATA","TCACTG"};
    private ResultValidate adenineResultValidate;
    private final String[] thymineSequenceDna = {"ATGCGA","CTGTGC","TTATGT","ATAAAG","ATTTTA","TCACTG"};
    private ResultValidate thymineResultValidate;
    private final String[] cytosineSequenceDna = {"ATGAGA","CAGCGA","TTACCT","AGACGG","ATCCCC","CCCCTG"};
    private ResultValidate cytosineResultValidate;
    private final String[] guanineSequenceDna = {"ATGGGG","CAGTGC","TTGTGT","AGGAGG","ATGGGG","GGGGTG"};
    private ResultValidate guanineResultValidate;

    @Before
    public void setUp(){
        adenineResultValidate=new ResultValidate();
        adenineResultValidate.setValid(true);
        adenineResultValidate.setSequenceCount(2);

        thymineResultValidate=new ResultValidate();
        thymineResultValidate.setValid(true);
        thymineResultValidate.setSequenceCount(1);

        cytosineResultValidate=new ResultValidate();
        cytosineResultValidate.setValid(true);
        cytosineResultValidate.setSequenceCount(1);

        guanineResultValidate=new ResultValidate();
        guanineResultValidate.setValid(true);
        guanineResultValidate.setSequenceCount(2);
    }

    @Test
    public void adenineSequenceCountDna(){
        ResultValidate resultValidate = verticalSequenceValidation.validate(adenineSequenceDna);
        Assert.assertEquals(adenineResultValidate, resultValidate);

    }

    @Test
    public void thymineSequenceCountDna(){
        ResultValidate resultValidate = verticalSequenceValidation.validate(thymineSequenceDna);
        Assert.assertEquals(thymineResultValidate, resultValidate);

    }

    @Test
    public void cytosineSequenceCountDna(){
        ResultValidate resultValidate = verticalSequenceValidation.validate(cytosineSequenceDna);
        Assert.assertEquals(cytosineResultValidate, resultValidate);

    }

    @Test
    public void guanineSequenceCountDna(){
        ResultValidate resultValidate = verticalSequenceValidation.validate(guanineSequenceDna);
        Assert.assertEquals(guanineResultValidate, resultValidate);

    }
}
