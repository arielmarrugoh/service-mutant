package com.magneto.servicemutant.consume;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.magneto.servicemutant.domain.dto.DnaDTO;
import com.magneto.servicemutant.events.consume.internal.DefaultSaveSmsConsume;
import com.magneto.servicemutant.services.IsMutantService;
import com.magneto.servicemutant.services.StatsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = {DefaultSaveSmsConsumeTest.class})
public class DefaultSaveSmsConsumeTest {


    @InjectMocks
    private DefaultSaveSmsConsume defaultSaveSmsConsume;
    @Mock
    private IsMutantService isMutantService;
    @Mock
    private StatsService statsService;
    @Mock
    private ObjectMapper mapper;
    private String json;

    private DnaDTO dnaDTO;

    @Before
    public void setUp(){
        dnaDTO = new DnaDTO();
        dnaDTO.setMutant(false);
        dnaDTO.setValue(new String[1]);
    }

    @Test
    public void publishSms() throws  Exception{
        String json= mapper.writeValueAsString(dnaDTO);
        defaultSaveSmsConsume.consume(json);
        Mockito.verify(isMutantService).save(null);
        Mockito.verify(statsService).calculate();
    }
}
