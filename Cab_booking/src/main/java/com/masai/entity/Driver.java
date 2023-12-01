package com.masai.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@PrimaryKeyJoinColumn(name="driverId")
public class Driver extends AbstractUser {

	@Column(insertable = false, updatable = false, nullable = false)
	private String driverId;

	@Min(value=1, message="id should be more than 1")
	private Integer licenseNo;
	@Min(value=1, message="id should be more than 1")
	private Double rating;
	private Boolean available;

	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="cabId")
	private Cab cab;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "driver", orphanRemoval = true)
	@JsonIgnore
	private TripBooking tripBooking;

}
