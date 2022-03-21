package io.newvisionsoftware.makarand.palsule.useremployeedetails.e.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.newvisionsoftware.makarand.palsule.useremployeedetails.u.entity.U;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ed")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class E {
	
	@Id
	@Column(name = "e_id")
	private int eId;
	
	@Column(name = "salary")
	private double salary;
	
	@Column(name = "designation")
	private String designation;
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "u_id")
	private U u;
}
