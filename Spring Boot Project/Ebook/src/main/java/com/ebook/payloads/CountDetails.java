package com.ebook.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountDetails {

	private Long bookCount;

	private Long categoryCount;

	private Long orderCount;

}
