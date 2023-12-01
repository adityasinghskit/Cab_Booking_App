package com.masai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;

@Entity
@Data
@PrimaryKeyJoinColumn(name="adminId")
public class Admin extends AbstractUser {

    @Column(insertable = false, updatable = false, nullable = false)
    private String adminId;
}
