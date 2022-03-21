package io.newvisionsoftware.makarand.palsule.useremployeedetails.e.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.newvisionsoftware.makarand.palsule.useremployeedetails.e.entity.E;
import io.newvisionsoftware.makarand.palsule.useremployeedetails.e.service.impl.EServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "/api")
public class EController {
	
	@Autowired
	private EServiceImpl eServiceImpl;
	
	@PostMapping(path = "/employee")
	public ResponseEntity<E> createAnEmployeeRecord(@RequestBody E e) {
		E tempEmployee = eServiceImpl.createEmployeeRecords(e);
		if(tempEmployee != null) 
			return new ResponseEntity<> (tempEmployee, HttpStatus.CREATED);
		else 
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(path = "/employee/{employeeId}")
	public ResponseEntity<E> fetchAnUserRecord (@PathVariable(name = "employeeId") int eId) {
		E tempEmployee = eServiceImpl.getAnEmployeeRecordById(eId);
		if(tempEmployee != null)
			return new ResponseEntity<> (tempEmployee, HttpStatus.OK);
		else 
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path = "/employees")
	public ResponseEntity<Iterable<E>> fetchAllUserRecords() { 
		Iterable<E> tempEmployee = eServiceImpl.getAllEmployeeRecords();
		if(tempEmployee != null)
			return ResponseEntity.of(Optional.of(tempEmployee));
		else 
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(path = "/employee")
	public ResponseEntity<List<E>> fetchUsersByDesignation(
			@RequestParam (required = true) String Designation) {
		List<E> tempEmployee = eServiceImpl.getEmployeesByDesignation(Designation);
		if(tempEmployee != null) 
			return ResponseEntity.ok(tempEmployee);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(path = "/employee/{empId}")
	public ResponseEntity<E> updateAnEmployeeRecord (@PathVariable(name = "empId") int empId ,
			@RequestBody E e) {
		E tempEmployee = eServiceImpl.updateAnEmployeeRecord(empId, e);
		if(tempEmployee != null) 
			return new ResponseEntity<> (tempEmployee, HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(path = "/employee/{empId}")
	public ResponseEntity<E> deactivateAnEmployeeRecord( @PathVariable (name = "empId") int empId) {
		E tempE = eServiceImpl.deactivateAnEmployeeRecord(empId);
		if (tempE != null) 
			return new ResponseEntity<>(HttpStatus.GONE);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
