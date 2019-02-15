package com.department.mongo.department.repository;

import com.department.mongo.department.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("com.department.mongo.department.repository.DepartmentRepository")
public interface DepartmentRepository extends MongoRepository<Department,String> {
    List<Department> findByDepartmentName(String departmentName);
    Department findByDepartmentId(String departmentId);
}
