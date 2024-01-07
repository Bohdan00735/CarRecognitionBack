package com.masterwork.carrecognition.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("S")
@NoArgsConstructor
@SuperBuilder
public class LastSearch extends TopPick {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "added_date")
    private LocalDateTime date;

}
