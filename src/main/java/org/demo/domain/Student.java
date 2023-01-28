package org.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student {
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Long id;
	private String studentIdentifier;
	private String studentJson;
}