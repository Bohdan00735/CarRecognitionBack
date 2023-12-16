package com.masterwork.carrecognition.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("F")
@NoArgsConstructor
@SuperBuilder
public class Favourite extends TopPick {
}
