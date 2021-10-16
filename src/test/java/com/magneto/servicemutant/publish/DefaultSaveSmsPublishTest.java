package com.magneto.servicemutant.publish;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.magneto.servicemutant.domain.dto.DnaDTO;
import com.magneto.servicemutant.events.publish.internal.DefaultSaveSmsPublish;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;

import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = {DefaultSaveSmsPublish.class})
public class DefaultSaveSmsPublishTest {

    @InjectMocks
    private DefaultSaveSmsPublish defaultSaveSmsPublish;
    @Mock
    private JmsTemplate jmsTemplate;
    private DnaDTO dnaDTO;
    @Mock
    private ObjectMapper mapper;
    String json;

    @Before
    public void setUp(){
        dnaDTO = new DnaDTO();
        dnaDTO.setMutant(true);
        dnaDTO.setValue(new String[1]);


        try {
            json= mapper.writeValueAsString(dnaDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void send() throws IOException {


        defaultSaveSmsPublish.send(dnaDTO);


    }
}
