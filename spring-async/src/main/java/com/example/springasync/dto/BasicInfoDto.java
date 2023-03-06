package com.example.springasync.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicInfoDto {

  private List<String> employeeNameList;
  private List<String> departmentNameList;
}
