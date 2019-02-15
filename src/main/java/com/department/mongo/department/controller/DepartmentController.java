package com.department.mongo.department.controller;

import com.department.mongo.department.model.DepartmentModel;
import com.department.mongo.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("com.department.mongo.department.controller.DepartmentController")
public class DepartmentController {

  @Autowired
  @Qualifier("com.department.mongo.department.service.impl.DepartmentServiceImpl")
  private DepartmentService departmentService;

  @PostMapping("/department")
  public ResponseEntity<DepartmentModel> createDepartment(@RequestBody DepartmentModel departmentModel) {
    DepartmentModel responseEntity = departmentService.addDepartment(departmentModel);
    return new ResponseEntity<DepartmentModel>(responseEntity, HttpStatus.OK);
  }

  @GetMapping("/department/name/{departmentName}")
  public ResponseEntity<List<DepartmentModel>> getDepartmentUsingName(
      @PathVariable("departmentName") String departmentName) {
    List<DepartmentModel> departmentModelList = departmentService.getDepartmentUsingName(departmentName);
    return new ResponseEntity<List<DepartmentModel>>(departmentModelList, HttpStatus.OK);
  }

  @GetMapping("/department/id/{departmentId}")
  public ResponseEntity<DepartmentModel> getDepartmentUsingId(
      @PathVariable("departmentId") String departmentId) {
    DepartmentModel departmentModel = departmentService.getDepartmentUsingId(departmentId);
    return new ResponseEntity<DepartmentModel>(departmentModel, HttpStatus.OK);
  }

}
