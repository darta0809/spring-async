package com.example.springasync.service;

import com.example.springasync.dto.DepartmentDataDto;
import com.example.springasync.dto.EmployeeDataDto;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class DemoService {

  private final RestTemplate restTemplate;

  @Async("executor")
  public CompletableFuture<EmployeeDataDto> getEmployeeData() throws InterruptedException {
    String threadName = Thread.currentThread().getName();
    System.out.println(threadName + ":get employee data start");

    EmployeeDataDto employeeDataDto = restTemplate
        .getForObject("http://localhost:8080/employee", EmployeeDataDto.class);

    Thread.sleep(2000);
    System.out.println(threadName + ":get employee data end");

    return CompletableFuture.completedFuture(employeeDataDto);
  }

  @Async("executor")
  public CompletableFuture<DepartmentDataDto> getDepartmentData() throws InterruptedException {
    String threadName = Thread.currentThread().getName();
    System.out.println(threadName + ":get department data start");

    DepartmentDataDto departmentDataDto = restTemplate
        .getForObject("http://localhost:8080/department", DepartmentDataDto.class);

    Thread.sleep(1000);
    System.out.println(threadName + ":get department data end");
    return CompletableFuture.completedFuture(departmentDataDto);
  }

}
