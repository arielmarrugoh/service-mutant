package com.magneto.servicemutant.validator;

import com.magneto.servicemutant.domain.dto.ResultValidate;
import com.magneto.servicemutant.validator.internal.HorizontalSequenceValidation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = {HorizontalSequenceValidation.class})
public class HorizontalSequenceValidationTest {

    @InjectMocks
    private HorizontalSequenceValidation horizontalSequenceValidation;
    private final String[] adenineSequenceDna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","AAAATA","TCACTG"};
    private ResultValidate adenineResultValidate;
    private final String[] thymineSequenceDna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","ATTTTA","TCACTG"};
    private ResultValidate thymineResultValidate;
    private final String[] cytosineSequenceDna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","ATCCCC","CCCCTG"};
    private ResultValidate cytosineResultValidate;
    private final String[] guanineSequenceDna = {"ATGGGG","CAGTGC","TTATGT","AGAAGG","ATGGGG","GGGGTG"};
    private ResultValidate guanineResultValidate;

    @Before
    public void setUp(){
        adenineResultValidate=new ResultValidate();
        adenineResultValidate.setValid(true);
        adenineResultValidate.setSequenceCount(1);

        thymineResultValidate=new ResultValidate();
        thymineResultValidate.setValid(true);
        thymineResultValidate.setSequenceCount(1);

        cytosineResultValidate=new ResultValidate();
        cytosineResultValidate.setValid(true);
        cytosineResultValidate.setSequenceCount(2);

        guanineResultValidate=new ResultValidate();
        guanineResultValidate.setValid(true);
        guanineResultValidate.setSequenceCount(3);
    }

    @Test
    public void adenineSequenceCountDna(){
        ResultValidate resultValidate = horizontalSequenceValidation.validate(adenineSequenceDna);
        Assert.assertEquals(adenineResultValidate, resultValidate);

    }

    @Test
    public void thymineSequenceCountDna(){
        ResultValidate resultValidate = horizontalSequenceValidation.validate(thymineSequenceDna);
        Assert.assertEquals(thymineResultValidate, resultValidate);

    }

    @Test
    public void cytosineSequenceCountDna(){
        ResultValidate resultValidate = horizontalSequenceValidation.validate(cytosineSequenceDna);
        Assert.assertEquals(cytosineResultValidate, resultValidate);

    }

    @Test
    public void guanineSequenceCountDna(){
        ResultValidate resultValidate = horizontalSequenceValidation.validate(guanineSequenceDna);
        Assert.assertEquals(guanineResultValidate, resultValidate);

    }
}
