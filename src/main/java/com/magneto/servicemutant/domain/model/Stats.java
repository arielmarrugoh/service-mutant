package com.magneto.servicemutant.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document(collection = "stats")
public class Stats {

    @MongoId
    private String id;
    private int count_mutant_dna;
    private int count_human_dna;
    private double ratio;
}
