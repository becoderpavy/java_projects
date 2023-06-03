package com.prog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HodResponse {

	private int id;

	private String hodName;

	private String collageName;

	private String departmentName;

}
