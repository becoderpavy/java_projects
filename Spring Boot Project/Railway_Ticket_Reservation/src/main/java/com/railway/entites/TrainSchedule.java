package com.railway.entites;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String runOnDay;

	private String departureTime;

	private String arrivalTime;

	@ManyToOne
	private TrainDtls train;
	
	@Transient
	private int trainId;

}
