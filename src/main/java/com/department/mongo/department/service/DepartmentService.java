package com.department.mongo.department.service;

import com.department.mongo.department.model.DepartmentModel;

import java.util.List;

public interface DepartmentService {
  DepartmentModel addDepartment(DepartmentModel departmentModel);
  DepartmentModel getDepartmentUsingId(String departmentId);
  List<DepartmentModel> getDepartmentUsingName(String departmentName);
}
