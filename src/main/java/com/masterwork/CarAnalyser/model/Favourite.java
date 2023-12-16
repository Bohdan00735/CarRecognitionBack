package com.masterwork.CarAnalyser.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("F")
@NoArgsConstructor
@SuperBuilder
public class Favourite extends TopPick {
}
