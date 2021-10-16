package com.magneto.servicemutant.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document(collection = "dnas")
public class Dna implements Serializable {

    @MongoId
    private String id;
    private String[] value;
    private boolean isMutant;

}
