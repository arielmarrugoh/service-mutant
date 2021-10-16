package com.magneto.servicemutant.services;

import com.magneto.servicemutant.domain.dto.DnaDTO;
import com.magneto.servicemutant.domain.dto.ResultValidate;
import com.magneto.servicemutant.domain.model.Dna;
import com.magneto.servicemutant.events.publish.SaveSms;
import com.magneto.servicemutant.repositories.infrastructure.DnaRepository;
import com.magneto.servicemutant.services.internal.DefaultIsMutantService;
import com.magneto.servicemutant.validator.internal.DefaultValidationProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = {DefaultIsMutantService.class})
public class DefaultIsMutantServiceTest {

    @InjectMocks
    private DefaultIsMutantService defaultIsMutantService;
    @Mock
    private DefaultValidationProvider defaultValidationProvider;
    @Mock
    private DnaRepository dnaRepository;
    @Mock
    private SaveSms saveSmse;
    private final String[] dnaMutant = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
    private final String[] notMutantDna = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
    private final String[] invalidDna = {"TTGCGA", "TGXCGA"};
    private Dna dna;

    @Before
    public void setUp(){
        ResultValidate resultValidateMutant= new ResultValidate();
        resultValidateMutant.setValid(true);
        resultValidateMutant.setSequenceCount(3);
        Mockito.when(defaultValidationProvider.validate(dnaMutant)).thenReturn(resultValidateMutant);

        ResultValidate resultValidateNotMutant= new ResultValidate();
        resultValidateNotMutant.setValid(true);
        resultValidateNotMutant.setSequenceCount(0);
        Mockito.when(defaultValidationProvider.validate(notMutantDna)).thenReturn(resultValidateNotMutant);

        ResultValidate resultInvalidate= new ResultValidate();
        resultInvalidate.setValid(false);
        resultInvalidate.setSequenceCount(0);
        Mockito.when(defaultValidationProvider.validate(invalidDna)).thenReturn(resultInvalidate);

        dna = new Dna();
        dna.setValue(dnaMutant);

    }

    @Test
    public void isMutant(){
        boolean isMutant= defaultIsMutantService.isMutant(dnaMutant);
        Assert.assertTrue(isMutant);
    }

    @Test
    public void NotMutant(){
        boolean isMutant= defaultIsMutantService.isMutant(notMutantDna);
        Assert.assertFalse(isMutant);
    }

    @Test
    public void dnaInvalid(){
        boolean isMutant= defaultIsMutantService.isMutant(invalidDna);
        Assert.assertFalse(isMutant);
    }

    @Test
    public void save(){
        DnaDTO dnaDTO = new DnaDTO();

        defaultIsMutantService.save(dnaDTO);

        Assert.assertNotNull(dnaDTO);
    }
}
