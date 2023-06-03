package com.prog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FaculityResponse {

	private int id;

	private String faculityName;

	private String collageName;

	private String departmentName;

}
