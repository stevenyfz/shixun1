package com.example.springboot04web.controller;

import com.example.springboot04web.dao.DepartmentDao;
import com.example.springboot04web.dao.EmployeeDao;
import com.example.springboot04web.entities.Department;
import com.example.springboot04web.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model)
    {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model)
    {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee)
    {
        System.out.println("保存的员工信息，"+employee);
        employeeDao.save(employee);
        // redirect: 表示重定向到一个地址
        // forward：表示转发到一个地址
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model)
    {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee)
    {
        System.out.println("修改的员工数据："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @PostMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id)
    {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
