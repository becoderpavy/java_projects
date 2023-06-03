package com.expense.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name cant blank")
	@Size(min = 2, max = 30)
	private String name;

	private String accountNumber;

	private String description;

	@Min(1)
	@Max(3)
	private Integer priority;

	private Double currentBalance;

	@PrePersist
	public void setBalance() {
		this.currentBalance = new Double(0);
	}

}
