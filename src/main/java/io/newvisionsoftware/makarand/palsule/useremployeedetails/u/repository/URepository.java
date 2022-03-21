package io.newvisionsoftware.makarand.palsule.useremployeedetails.u.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.newvisionsoftware.makarand.palsule.useremployeedetails.u.entity.U;

@Repository
public interface URepository extends CrudRepository<U, Integer> {

	public boolean existsByLastNameContainingIgnoreCase(String s);
	public List<U> findByLastNameContainingIgnoreCaseAndStatusEquals(String s, int status);
	public List<U> findByLastNameContainingIgnoreCase(String s);
}
