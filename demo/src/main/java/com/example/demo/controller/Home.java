package com.example.demo.controller;

import com.example.demo.model.Branch;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

@Controller
public class Home {
    @Autowired
    EmployeeService employeeService;
    //Hàm hiển thị
    @GetMapping("/home")
    public String toan(Model model) {
        model.addAttribute("employee", employeeService.getAll());
//        Chuyển đến home.jsp
        return "home";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String code) {
        employeeService.delete(code);
        return "redirect:/home";
    }

    @GetMapping("/create")
    public String showFormCreate() {
        return "formCreate";
    }

    @PostMapping("/create")
    public String create(Employee employee, Branch branch) {
        employeeService.create(employee);
        return "redirect:/home";
    }

    @GetMapping("/edit")
    public String showFormEdit(Model model, @RequestParam String code) {
        model.addAttribute("edit", employeeService.findEmployeeByCode(code));
        return "formEdit";
    }

    @PostMapping("/edit")
    public String edit(Employee employee) {
        employeeService.edit(employee);
        return "redirect:/home";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam String search) {
        List<Employee> list = employeeService.searchEmployee(search);
        model.addAttribute("student", list);
        return "home";
    }


}
