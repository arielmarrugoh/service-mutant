package com.magneto.servicemutant.events.publish.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.magneto.servicemutant.domain.dto.DnaDTO;
import com.magneto.servicemutant.events.publish.SaveSms;
import com.magneto.servicemutant.util.NitrogenousBaseConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class DefaultSaveSmsPublish implements SaveSms {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private ObjectMapper mapper;

    @Override
    public void send(DnaDTO dnaDTO) throws IOException {
        String json= mapper.writeValueAsString(dnaDTO);
        jmsTemplate.convertAndSend(NitrogenousBaseConstant.INBOUND_SAVE, json);
    }
}
