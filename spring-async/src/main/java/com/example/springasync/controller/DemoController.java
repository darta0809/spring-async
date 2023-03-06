package com.example.springasync.controller;

import com.example.springasync.dto.BasicInfoDto;
import com.example.springasync.dto.DepartmentDataDto;
import com.example.springasync.dto.DepartmentDto;
import com.example.springasync.dto.EmployeeDataDto;
import com.example.springasync.dto.EmployeeDto;
import com.example.springasync.service.DemoService;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

  private final DemoService demoService;

  @GetMapping(value = "get")
  public BasicInfoDto getBasicInfo() throws InterruptedException, ExecutionException {

    CompletableFuture<EmployeeDataDto> employeeDataDtoCompletableFuture =
        demoService.getEmployeeData();
    CompletableFuture<DepartmentDataDto> departmentDataDtoCompletableFuture =
        demoService.getDepartmentData();

    CompletableFuture.allOf(employeeDataDtoCompletableFuture, departmentDataDtoCompletableFuture)
        .join();

    List<EmployeeDto> employeeDtoList =
        employeeDataDtoCompletableFuture.get().getEmployeeDtoList();
    List<DepartmentDto> departmentDtoList =
        departmentDataDtoCompletableFuture.get().getDepartmentDtoList();

    return new BasicInfoDto(
        employeeDtoList.stream().map(EmployeeDto::getName).toList(),
        departmentDtoList.stream().map(DepartmentDto::getName).toList());

  }
}
