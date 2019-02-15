package com.department.mongo.department.service.impl;

import com.department.mongo.department.entity.Department;
import com.department.mongo.department.model.DepartmentModel;
import com.department.mongo.department.repository.DepartmentRepository;
import com.department.mongo.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("com.department.mongo.department.service.impl.DepartmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  @Qualifier("com.department.mongo.department.repository.DepartmentRepository")
  private DepartmentRepository departmentRepository;

  @Override
  public DepartmentModel addDepartment(DepartmentModel departmentModel) {
    Department department = convertModelToEntity(departmentModel);
    departmentRepository.save(department);
    return convertEntityToModel(department);
  }

  @Override
  public DepartmentModel getDepartmentUsingId(String departmentId) {
    Department department = departmentRepository.findByDepartmentId(departmentId);
    DepartmentModel departmentModel = convertEntityToModel(department);
    return departmentModel;
  }

  @Override
  public List<DepartmentModel> getDepartmentUsingName(String departmentName) {
    List<Department> departmentList = departmentRepository.findByDepartmentName(departmentName);
    List<DepartmentModel> departmentModels = new ArrayList<>();
    for(Department department : departmentList){
      departmentModels.add(convertEntityToModel(department));
    }
    return departmentModels;
  }

  private Department convertModelToEntity(DepartmentModel departmentModel){
    Department department = new Department();
    department.setDepartmentId(departmentModel.getId());
    department.setDepartmentName(departmentModel.getDepartmentName());
    department.setManagerId(departmentModel.getManagerId());
    return department;
  }

  private DepartmentModel convertEntityToModel(Department department){
    DepartmentModel departmentModel = new DepartmentModel();
    departmentModel.setId(department.getDepartmentId());
    departmentModel.setDepartmentName(department.getDepartmentName());
    departmentModel.setManagerId(department.getManagerId());
    return departmentModel;
  }
}

