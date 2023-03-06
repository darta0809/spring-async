package com.example.springasync.controller;

import com.example.springasync.dto.EmployeeDataDto;
import com.example.springasync.dto.EmployeeDto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  @GetMapping("employee")
  public EmployeeDataDto getEmployeeData() {
    List<EmployeeDto> employeeDtoList = List.of(
        new EmployeeDto(1L, "john"),
        new EmployeeDto(2L, "gary"));

    return new EmployeeDataDto(employeeDtoList);
  }
}
