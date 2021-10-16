package com.magneto.servicemutant.validator;


import com.magneto.servicemutant.domain.dto.ResultValidate;
import com.magneto.servicemutant.validator.internal.ReverseDiagonalSequenceValidation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = {ReverseDiagonalSequenceValidation.class})
public class ReverseDiagonalSequenceValidationTest {

    @InjectMocks
    private ReverseDiagonalSequenceValidation reverseDiagonalSequenceValidation;
    private final String[] adenineSequenceDnaAsc = {"AAGCGA","AAATAC","ATAAGT","GCATAG","GAAAGA","TCACTA"};
    private ResultValidate adenineResultValidateAsc;
    private final String[] adenineSequenceDnaDesc = {"ATGCAG","AAGTCA","ATATAT","AGAATG","GAAAAA","TCACTA"};
    private ResultValidate adenineResultValidateDesc;

    private final String[] thymineSequenceDnaAsc = {"GTGCGA","CTTTTC","TTATGT","ATTATG","ATTTTA","TCACTG"};
    private ResultValidate thymineResultValidateAsc;
    private final String[] thymineSequenceDnaDesc = {"TTGCGA","ATGTGT","ATTGTT","AGTTTG","GATATA","TCACTG"};
    private ResultValidate thymineResultValidateDesc;

    private final String[] cytosineSequenceDnaAsc = {"CTGGCA","CCGCGC","ACCCGT","ACGCTG","GAACTA","TCACTG"};
    private ResultValidate cytosineResultValidateAsc;
    private final String[] cytosineSequenceDnaDesc = {"ACGAGA","CACCGA","TTACCT","AGACCG","ATCCCC","CCCCTG"};
    private ResultValidate cytosineResultValidateDesc;

    private final String[] guanineSequenceDnaAsc = {"GGAGGG","CGGTGC","TGAGGT","GGAGGG","ATCGGG","GGGGTG"};
    private ResultValidate guanineResultValidateAsc;

    private final String[] guanineSequenceDnaDesc = {"GAAGGG","GGGTGC","TGGGGT","AGGGCG","ATGGGG","GGGGTG"};
    private ResultValidate guanineResultValidateDesc;

    @Before
    public void setUp(){
        adenineResultValidateDesc=new ResultValidate();
        adenineResultValidateDesc.setValid(true);
        adenineResultValidateDesc.setSequenceCount(1);

        adenineResultValidateAsc=new ResultValidate();
        adenineResultValidateAsc.setValid(true);
        adenineResultValidateAsc.setSequenceCount(1);

        thymineResultValidateAsc=new ResultValidate();
        thymineResultValidateAsc.setValid(true);
        thymineResultValidateAsc.setSequenceCount(1);

        thymineResultValidateDesc=new ResultValidate();
        thymineResultValidateDesc.setValid(true);
        thymineResultValidateDesc.setSequenceCount(1);

        cytosineResultValidateAsc=new ResultValidate();
        cytosineResultValidateAsc.setValid(true);
        cytosineResultValidateAsc.setSequenceCount(1);

        cytosineResultValidateDesc=new ResultValidate();
        cytosineResultValidateDesc.setValid(true);
        cytosineResultValidateDesc.setSequenceCount(1);

        guanineResultValidateAsc=new ResultValidate();
        guanineResultValidateAsc.setValid(true);
        guanineResultValidateAsc.setSequenceCount(1);

        guanineResultValidateDesc=new ResultValidate();
        guanineResultValidateDesc.setValid(true);
        guanineResultValidateDesc.setSequenceCount(2);

    }


    @Test
    public void diagonalSequenceAdenineValidationAsc(){
        ResultValidate resultValidate = this.reverseDiagonalSequenceValidation.validate(adenineSequenceDnaAsc);
        Assert.assertEquals(adenineResultValidateAsc, resultValidate);
    }

    @Test
    public void diagonalSequenceAdenineValidationDesc(){
        ResultValidate resultValidate = this.reverseDiagonalSequenceValidation.validate(adenineSequenceDnaDesc);
        Assert.assertEquals(adenineResultValidateDesc, resultValidate);
    }

    @Test
    public void diagonalSequencethymineValidationAsc(){
        ResultValidate resultValidate = this.reverseDiagonalSequenceValidation.validate(thymineSequenceDnaAsc);
        Assert.assertEquals(thymineResultValidateAsc, resultValidate);
    }

    @Test
    public void diagonalSequencethymineValidationDesc(){
        ResultValidate resultValidate = this.reverseDiagonalSequenceValidation.validate(thymineSequenceDnaDesc);
        Assert.assertEquals(thymineResultValidateDesc, resultValidate);
    }

    @Test
    public void diagonalSequenceCytosineValidationAsc(){
        ResultValidate resultValidate = this.reverseDiagonalSequenceValidation.validate(cytosineSequenceDnaAsc);
        Assert.assertEquals(cytosineResultValidateAsc, resultValidate);
    }

    @Test
    public void diagonalSequenceCytosineValidationDesc(){
        ResultValidate resultValidate = this.reverseDiagonalSequenceValidation.validate(cytosineSequenceDnaDesc);
        Assert.assertEquals(cytosineResultValidateDesc, resultValidate);
    }

    @Test
    public void diagonalSequenceGuanineValidationAsc(){
        ResultValidate resultValidate = this.reverseDiagonalSequenceValidation.validate(guanineSequenceDnaAsc);
        Assert.assertEquals(guanineResultValidateAsc, resultValidate);
    }

    @Test
    public void diagonalSequenceGuanineValidationDesc(){
        ResultValidate resultValidate = this.reverseDiagonalSequenceValidation.validate(guanineSequenceDnaDesc);
        Assert.assertEquals(guanineResultValidateDesc, resultValidate);
    }
}
