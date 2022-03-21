package io.newvisionsoftware.makarand.palsule.useremployeedetails.u.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.newvisionsoftware.makarand.palsule.useremployeedetails.u.entity.U;
import io.newvisionsoftware.makarand.palsule.useremployeedetails.u.repository.URepository;
import io.newvisionsoftware.makarand.palsule.useremployeedetails.u.service.UService;

@Service
public class UServiceImpl implements UService {

	@Autowired
	private URepository uRepository;
	
	@Override
	public U createAnUserRecord(U u) {
		return uRepository.save(u);
	}

	@Override
	public U getAnUserRecordById(int userId) {
		if(uRepository.existsById(userId)) {
			if(uRepository.findById(userId).get().getStatus()==1) 
				return uRepository.findById(userId).get();
			else 
				return null;
		} else
			return null;
	}

	@Override
	public Iterable<U> getAllRecords() {
		return uRepository.findAll();
	}

	@Override
	public List<U> getRecordsBasedOnLastNameAndStatus(String s, boolean val) {
		if(uRepository.existsByLastNameContainingIgnoreCase(s)) {
			if(val == true)
				return uRepository.findByLastNameContainingIgnoreCase(s);
			else if (val == false) 
				return uRepository.findByLastNameContainingIgnoreCaseAndStatusEquals(s, 1);
			else 
				return uRepository.findByLastNameContainingIgnoreCaseAndStatusEquals(s, 1);
		}
		else
			return null;
	}

	@Override
	public U updateUserRecords(int userId, U u) {
		if(uRepository.existsById(userId)) {
			U tempUser = uRepository.findById(userId).get();
			tempUser.setFirstName(u.getFirstName());
			tempUser.setLastName(u.getLastName());
			tempUser.setContactNumber(u.getContactNumber());
			tempUser.setAddress(u.getAddress());
			tempUser.setJob(u.getJob());
			tempUser.setRole(u.getRole());
			tempUser.setStatus(u.getStatus());
			return uRepository.save(tempUser);
		} else
			return null;
	}

	@Override
	public U deactivateAnUser(int userId) {
		if(uRepository.existsById(userId)) {
			if(uRepository.findById(userId).get().getStatus() == 1) {
				U tempUser = uRepository.findById(userId).get();
				tempUser.setStatus(0);
				return uRepository.save(tempUser);
			} else 
				return null;
		} else
			return null;
	}

}
