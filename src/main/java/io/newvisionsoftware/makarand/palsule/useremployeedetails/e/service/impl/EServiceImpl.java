package io.newvisionsoftware.makarand.palsule.useremployeedetails.e.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.newvisionsoftware.makarand.palsule.useremployeedetails.e.entity.E;
import io.newvisionsoftware.makarand.palsule.useremployeedetails.e.repository.ERepository;
import io.newvisionsoftware.makarand.palsule.useremployeedetails.e.service.EService;

@Service
public class EServiceImpl implements EService {

	@Autowired
	private ERepository eRepository;
		
	@Override
	public E createEmployeeRecords(E e) {
		return eRepository.save(e);
	}

	@Override
	public E getAnEmployeeRecordById(int id) {
		if(eRepository.existsById(id)) {
			E tempEmployee = eRepository.findById(id).get();
			if(tempEmployee.getU().getStatus() != 1) 
				return null;
			else
				return tempEmployee;
		} else
			return null;
	}

	@Override
	public Iterable<E> getAllEmployeeRecords() {
		return eRepository.findAll();
	}

	@Override
	public List<E> getEmployeesByDesignation(String s) {
		if(eRepository.existsByDesignationEqualsIgnoreCase(s)) {
			return eRepository.findByDesignationEqualsIgnoreCase(s);
		} else
			return null;
	}

	@Override
	public E updateAnEmployeeRecord(int empId, E e) {
		if(eRepository.existsById(empId)) {
			E tempEmployee = eRepository.findById(empId).get();
			tempEmployee.setSalary(e.getSalary());
			tempEmployee.setDesignation(e.getDesignation());
			tempEmployee.setU(e.getU());
			return eRepository.save(tempEmployee);
		} else
			return null;
	}

	@Override
	public E deactivateAnEmployeeRecord(int empId) {
		if(eRepository.existsById(empId)) {
			E tempEmployee = eRepository.findById(empId).get();
			if(tempEmployee.getU().getStatus() == 1) {
				tempEmployee.getU().setStatus(0);
				return eRepository.save(tempEmployee);
			} else
				return null;
		} else
			return null;
	}

}
