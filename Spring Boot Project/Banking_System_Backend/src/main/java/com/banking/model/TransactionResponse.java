package com.banking.model;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

	private String accountno;

	private String name;

	private String transType;

	private String transDtls;

	private Double amount;

	private LocalDate date;

	private LocalTime time;

}
