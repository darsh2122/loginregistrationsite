package com.fdmgroup.springassessment.Controller;

import com.fdmgroup.springassessment.Model.Employee;
import com.fdmgroup.springassessment.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Initial Mapping
    @GetMapping
    public String toIndex(){
        return "index";
    }

    /*--------------Registration Section-------------*/
    @GetMapping("/register")
    public String goToRegister(Model model){
        model.addAttribute ("employee", new Employee ());
        return "register";
    }

    @PostMapping("/processEmployee")
    public String processEmployee(Employee employee, Model model){
        if (employeeService.validToRegister (employee)){
            model.addAttribute ("username",employee.getUsername ());
            return "Employee-registered";
        }
        model.addAttribute ("error","Username and Password must have at least 8 characters and no spaces allowed.");
        return "register";
    }


    /*--------------Log-in Section-------------*/

    @GetMapping("/login")
    public String goToLogin(Model model,Employee employee){
        model.addAttribute ("employee",employee);
        return "login";
    }

    @PostMapping("/login")
    public String process_login(Employee employee, Model model,HttpSession session){
        if (employeeService.authenticated (employee)){
            session.setAttribute ("username", employee.getUsername ());
            return "login-success";
        }
        model.addAttribute ("error","Invalid Log-in");
        return "login";
    }

    @GetMapping("/login-success")
    public String goToLoginSuccess(HttpSession session){
        String username = (String) session.getAttribute ("username");
        return "login-success";
    }

}
