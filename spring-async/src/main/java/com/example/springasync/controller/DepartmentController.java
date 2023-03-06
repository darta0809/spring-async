package com.example.springasync.controller;

import com.example.springasync.dto.DepartmentDataDto;
import com.example.springasync.dto.DepartmentDto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

  @GetMapping("department")
  public DepartmentDataDto getDepartmentData() {
    List<DepartmentDto> departmentDtoList = List.of(
        new DepartmentDto(1L, "Marketing"),
        new DepartmentDto(2L, "HR")
    );
    return new DepartmentDataDto(departmentDtoList);
  }
}
