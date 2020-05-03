package com.abk.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abk.department.model.Department;
import com.abk.department.repository.DepartmentRepository;

import io.swagger.annotations.Api;

@Api
@RestController
public class DepartmentController {

	@Autowired
	LoadBalancerClient loadBalancerClient;

	@Autowired
	private DepartmentRepository departmentRepository;

	@GetMapping("/departments/{department}")
	public String getDepartment(@PathVariable String department) {
//		ServiceInstance serviceInstance = loadBalancerClient.choose("department");
//		if (serviceInstance != null) {
//			return serviceInstance.getUri().toString();
//		}
		return department;
	}

	@PutMapping("/save")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentRepository.save(department);
	}
}