package com.masterwork.CarAnalyser.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("S")
@NoArgsConstructor
@SuperBuilder
public class LastSearch extends TopPick {
}
