package com.masai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@PrimaryKeyJoinColumn(name="customerId")
public class Customer extends AbstractUser {

	@Column(insertable = false, updatable = false, nullable = false)
	private String customerId;

	private boolean journeyStatus;
	
}
