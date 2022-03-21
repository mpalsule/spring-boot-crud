package io.newvisionsoftware.makarand.palsule.useremployeedetails.e.service;

import java.util.List;

import org.springframework.stereotype.Component;

import io.newvisionsoftware.makarand.palsule.useremployeedetails.e.entity.E;

@Component
public interface EService {
	
	public E createEmployeeRecords(E e);
	public E getAnEmployeeRecordById(int id);
	public Iterable<E> getAllEmployeeRecords(); 
	public List<E> getEmployeesByDesignation(String s);
	public E updateAnEmployeeRecord(int empId,E e);
	public E deactivateAnEmployeeRecord(int empId);
}
