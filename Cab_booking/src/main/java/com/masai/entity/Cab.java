package com.masai.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.masai.dto.Auditable;
import com.masai.enums.CabType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Cab extends Auditable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String cabId;

    @Enumerated(EnumType.STRING)
    private CabType carType;

    private Integer ratePerKm;

    @OneToOne(cascade=CascadeType.ALL,mappedBy="cab",orphanRemoval = true)
    @JsonIgnore
    private Driver driver;
}
