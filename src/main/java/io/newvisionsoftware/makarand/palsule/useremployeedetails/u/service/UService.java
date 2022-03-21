package io.newvisionsoftware.makarand.palsule.useremployeedetails.u.service;

import java.util.List;

import org.springframework.stereotype.Component;

import io.newvisionsoftware.makarand.palsule.useremployeedetails.u.entity.U;

@Component
public interface UService {
	
	public U createAnUserRecord(U u);
	public U getAnUserRecordById(int userId);
	public Iterable<U> getAllRecords();
	public List<U> getRecordsBasedOnLastNameAndStatus(String s, boolean val);
	public U updateUserRecords(int userId, U u);
	public U deactivateAnUser(int userId);
}
