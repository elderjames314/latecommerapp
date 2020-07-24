package com.aapeliltd.latecommerapp.v1.backend.repository;

import com.aapeliltd.latecommerapp.v1.backend.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select e from Employee e where e.name LIKE :search or e.email LIKE :search or e.address LIKE :search")
    Page<Employee> findEmployeeByNameOrEmailOrAddress(
            @Param("search") String search, Pageable pageable);


}
