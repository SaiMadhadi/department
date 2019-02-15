package com.department.mongo.department.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@ToString(doNotUseGetters = true)
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "department")
public class Department implements Serializable {

  @Indexed(unique = true)
  private String id;

  private String departmentId;

  private String departmentName;

  private String managerId;
}