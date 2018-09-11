package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.users.Department;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DepartmentsManager {
    private ArrayList<Department> departments = new ArrayList<>();

    public Department createInstance(String departmentId) {
        Department department = getDepartmentById(departmentId);
        if (department == null) {
            department = new Department(departmentId);
            departments.add(department);
        }
        return department;
    }

    public Department getDepartmentById(String depId) {
        return departments.stream().filter(department -> department.getId().equals(depId)).findAny().orElse(null);
    }
}
