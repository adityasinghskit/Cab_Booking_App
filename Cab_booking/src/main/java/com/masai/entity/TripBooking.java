package com.masai.entity;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import com.masai.dto.Auditable;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TripBooking extends Auditable {
	   @Id
	   @GeneratedValue(generator = "uuid")
	   @GenericGenerator(name = "uuid", strategy = "uuid2")
	   private String tripBookingId;
	   @NotNull
	   private String customerId;
	   
	   @OneToOne(cascade=CascadeType.ALL)
	   @JoinColumn(name="driver_id",referencedColumnName = "driverID")
	   private Driver driver;
 
	   @NotNull(message = "{From Location notNull}")
	   private String fromLocation;
	   
	   @NotNull(message = "{To Loccation notNull}")
	   private String toLocation;

	   @FutureOrPresent(message = "{futOrPres}")
	   @NotNull(message = "{data not null}")
	   @Temporal(TemporalType.TIMESTAMP)
	   @CreatedDate
	   private Date fromDateTime;

	   @FutureOrPresent(message = "{futOrPres}")
	   @NotNull(message = "{data not null}")
	   @Temporal(TemporalType.TIMESTAMP)
       private Date toDateTime;
	   
       private Integer km;
       private Integer  totalamount;
       private Boolean payment;
   
}
