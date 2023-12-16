package com.masterwork.carrecognition.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("S")
@NoArgsConstructor
@SuperBuilder
public class LastSearch extends TopPick {
}
