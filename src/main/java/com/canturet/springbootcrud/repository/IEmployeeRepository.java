package com.canturet.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.canturet.springbootcrud.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
