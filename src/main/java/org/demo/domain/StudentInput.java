package org.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInput {
	private Long id ;
	private String studentIdentifier ;
	private String studentJson;
}