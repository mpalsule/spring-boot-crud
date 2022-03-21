package io.newvisionsoftware.makarand.palsule.useremployeedetails.u.controller;

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

import io.newvisionsoftware.makarand.palsule.useremployeedetails.u.entity.U;
import io.newvisionsoftware.makarand.palsule.useremployeedetails.u.service.impl.UServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "/api")
public class UController {

	@Autowired
	private UServiceImpl uServiceImpl;
	
	@PostMapping(path = "/user")
	public ResponseEntity<U> creatingRecords(@RequestBody U u) {
		U tempUser = uServiceImpl.createAnUserRecord(u);
		if(tempUser != null)
			return new ResponseEntity<> (tempUser , HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(path = "/user/{userId}")
	public ResponseEntity<U> fetchingAnUserRecord(@PathVariable(name = "userId") int userId) {
		U u = uServiceImpl.getAnUserRecordById(userId);
		if(u != null)
			return new ResponseEntity<U>(u,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path = "/users")
	public ResponseEntity<Iterable<U>> fetchAllUserRecords() {
		Iterable<U> tempUser = uServiceImpl.getAllRecords();
		if(tempUser != null) 
			return ResponseEntity.of(Optional.of(tempUser));
		else 
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(path = "/user")
	public ResponseEntity<List<U>> fetchRecordsByLastName(
			@RequestParam(required = true) String LastName,
			@RequestParam(required = false) boolean all) {
		List<U> tempUser = uServiceImpl.getRecordsBasedOnLastNameAndStatus(LastName, all);
		if(tempUser != null)
			return ResponseEntity.of(Optional.of(tempUser));
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(path = "/user/{userId}")
	public ResponseEntity<U> updateAnUserRecords (@PathVariable (name = "userId") int userId,
			@RequestBody U u) {
		U tempUser = uServiceImpl.updateUserRecords(userId, u);
		if(tempUser != null)
			return new ResponseEntity<> ( tempUser, HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(path = "/user/{userId}")
	public ResponseEntity<U> deactivateUser(@PathVariable (name = "userId") int userId) {
		U tempU = uServiceImpl.deactivateAnUser(userId);
		if(tempU != null) 
			return new ResponseEntity<>(HttpStatus.GONE);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
