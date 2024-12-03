package com.example.Spring.Example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Spring.Example.Models.*;
import com.example.Spring.Example.Repositories.CustomerRepo;
import com.example.Spring.Example.Repositories.StaffRepo;
import com.example.Spring.Example.Service.CustomerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    StaffRepo staffRepo;

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register_page";
    }
    
    @PostMapping("/req/signup")
    public ResponseEntity<ResponseObject> handleSignUp(@RequestBody Customer customer) {
        Customer registeredCustomer = customerService.registerCustomer(customer);
        
        if (registeredCustomer != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(true, "Register Successfully", registeredCustomer)
            );
        } else {
            // Nếu có lỗi trong quá trình đăng ký
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseObject(false, "Registration Failed", null)
            );
        }
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login_page";
    }

    @PostMapping("/req/login")
    public String handleLogin(@RequestParam String email, @RequestParam String password, HttpSession session) {
        // Xử lý đăng nhập tại đây
        // Kiểm tra thông tin đăng nhập
        Customer customer = customerRepo.findByEmailAndPassword(email, password).orElse(null);
        Staff staff = staffRepo.findByEmailAndPassword(email, password).orElse(null);
        if (customer != null) {
            session.setAttribute("currentCustomer", customer);
            return "redirect:/dashboard";
        } else if (staff != null) {
            session.setAttribute("currentStaff", staff);
            return "redirect:/dashboard";
        }
        // Nếu thành công, chuyển hướng đến trang chính
        // Nếu thất bại, trả về trang đăng nhập với thông báo lỗi
        return "redirect:/login"; // Hoặc chuyển hướng đến trang lỗi nếu không đăng nhập được
    }

    @GetMapping("/dashboard")
    public String switchToDashBoard() {
        return "index";
    }
}
