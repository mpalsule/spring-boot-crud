package io.newvisionsoftware.makarand.palsule.useremployeedetails.e.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.newvisionsoftware.makarand.palsule.useremployeedetails.e.entity.E;

@Repository
public interface ERepository extends CrudRepository<E, Integer> {
	public boolean existsByDesignationEqualsIgnoreCase(String s);
	public List<E> findByDesignationEqualsIgnoreCase(String s);
}
