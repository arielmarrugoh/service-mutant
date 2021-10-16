package com.magneto.servicemutant.validator;


import com.magneto.servicemutant.domain.dto.ResultValidate;
import com.magneto.servicemutant.validator.internal.DiagonalSequenceValidation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = {DiagonalSequenceValidation.class})
public class DiagonalSequenceValidationTest{

    @InjectMocks
    private DiagonalSequenceValidation diagonalSequenceValidation;
    private final String[] adenineSequenceDnaAsc = {"AAGCGA","AAATGC","ATAAGT","AGAAAG","GAAATA","TCACTG"};
    private ResultValidate adenineResultValidateAsc;
    private final String[] adenineSequenceDnaDesc = {"ATGCGA","AAGTGC","ATATGT","AGAATG","GAAATA","TCACTG"};
    private ResultValidate adenineResultValidateDesc;

    private final String[] thymineSequenceDnaAsc = {"GTGCGA","CTTTGC","TTATGT","ATAATG","ATTTTA","TCACTG"};
    private ResultValidate thymineResultValidateAsc;
    private final String[] thymineSequenceDnaDesc = {"TTGCGA","ATGTGC","ATTTGT","AGTTTG","GAATTA","TCACTG"};
    private ResultValidate thymineResultValidateDesc;

    private final String[] cytosineSequenceDnaAsc = {"ACGAGA","CACCGA","TTACCT","AGACCG","ATCCCC","CCCCTG"};
    private ResultValidate cytosineResultValidateAsc;
    private final String[] cytosineSequenceDnaDesc = {"CTGCGA","CCGTGC","ACCCGT","AGCCTG","GAACTA","TCACTG"};
    private ResultValidate cytosineResultValidateDesc;

    private final String[] guanineSequenceDnaAsc = {"GGAGGG","CGGTGC","TTAGGT","AGGGGG","ATGGGG","GGGGTG"};
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
        adenineResultValidateAsc.setSequenceCount(2);

        thymineResultValidateAsc=new ResultValidate();
        thymineResultValidateAsc.setValid(true);
        thymineResultValidateAsc.setSequenceCount(1);

        thymineResultValidateDesc=new ResultValidate();
        thymineResultValidateDesc.setValid(true);
        thymineResultValidateDesc.setSequenceCount(2);

        cytosineResultValidateAsc=new ResultValidate();
        cytosineResultValidateAsc.setValid(true);
        cytosineResultValidateAsc.setSequenceCount(1);

        cytosineResultValidateDesc=new ResultValidate();
        cytosineResultValidateDesc.setValid(true);
        cytosineResultValidateDesc.setSequenceCount(2);

        guanineResultValidateAsc=new ResultValidate();
        guanineResultValidateAsc.setValid(true);
        guanineResultValidateAsc.setSequenceCount(1);

        guanineResultValidateDesc=new ResultValidate();
        guanineResultValidateDesc.setValid(true);
        guanineResultValidateDesc.setSequenceCount(2);

    }

    @Test
    public void diagonalSequenceAdenineValidationDesc(){
        ResultValidate resultValidate = this.diagonalSequenceValidation.validate(adenineSequenceDnaDesc);
        Assert.assertEquals(adenineResultValidateDesc, resultValidate);
    }

    @Test
    public void diagonalSequenceAdenineValidationAsc(){
        ResultValidate resultValidate = this.diagonalSequenceValidation.validate(adenineSequenceDnaAsc);
        Assert.assertEquals(adenineResultValidateAsc, resultValidate);
    }

    @Test
    public void diagonalSequencethymineValidationAsc(){
        ResultValidate resultValidate = this.diagonalSequenceValidation.validate(thymineSequenceDnaAsc);
        Assert.assertEquals(thymineResultValidateAsc, resultValidate);
    }

    @Test
    public void diagonalSequencethymineValidationDesc(){
        ResultValidate resultValidate = this.diagonalSequenceValidation.validate(thymineSequenceDnaDesc);
        Assert.assertEquals(thymineResultValidateDesc, resultValidate);
    }

    @Test
    public void diagonalSequenceCytosineValidationAsc(){
        ResultValidate resultValidate = this.diagonalSequenceValidation.validate(cytosineSequenceDnaAsc);
        Assert.assertEquals(cytosineResultValidateAsc, resultValidate);
    }

    @Test
    public void diagonalSequenceCytosineValidationDesc(){
        ResultValidate resultValidate = this.diagonalSequenceValidation.validate(cytosineSequenceDnaDesc);
        Assert.assertEquals(cytosineResultValidateDesc, resultValidate);
    }

    @Test
    public void diagonalSequenceGuanineValidationAsc(){
        ResultValidate resultValidate = this.diagonalSequenceValidation.validate(guanineSequenceDnaAsc);
        Assert.assertEquals(guanineResultValidateAsc, resultValidate);
    }

    @Test
    public void diagonalSequenceGuanineValidationDesc(){
        ResultValidate resultValidate = this.diagonalSequenceValidation.validate(guanineSequenceDnaDesc);
        Assert.assertEquals(guanineResultValidateDesc, resultValidate);
    }
}
