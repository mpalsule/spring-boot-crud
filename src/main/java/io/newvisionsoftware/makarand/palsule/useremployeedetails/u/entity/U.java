package io.newvisionsoftware.makarand.palsule.useremployeedetails.u.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name = "ud")
@Getter
@Setter
public class U {
	
	@Id
	@Column(name = "u_id")
	private int userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "contact_number")
	private long contactNumber;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "job")
	private String job;
	
	@Column(name = "role")
	private int role;
	
	@Column(name = "status")
	private int status;
}
