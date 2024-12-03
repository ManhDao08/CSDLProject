package com.example.Spring.Example.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.Spring.Example.Models.*;
import com.example.Spring.Example.Service.*;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;  // Dịch vụ xử lý thông tin cửa hàng

    @GetMapping("/details")
    @ResponseBody
    public Map<String, Object> getStoreDetails(HttpSession session) {
        Staff currentStaff = (Staff) session.getAttribute("currentStaff"); // Lấy thông tin nhân viên đăng nhập từ session

        if (currentStaff == null) {
            return Map.of("error", "No staff logged in");
        }

        // Lấy thông tin cửa hàng, film, customer, staff
        List<Film> films = storeService.getFilmsByStore(currentStaff.getStoreID());
        List<Customer> customers = storeService.getCustomersByStore(currentStaff.getStoreID());
        List<Staff> staff = storeService.getStaffByStore(currentStaff.getStoreID());

        Map<String, Object> storeDetails = new HashMap<>();
        storeDetails.put("films", films);
        storeDetails.put("customers", customers);
        storeDetails.put("staff", staff);

        return storeDetails;  // Trả về thông tin cửa hàng
    }

    // @PostMapping("/store/add-films")
    // public ResponseEntity<String> addFilm(@RequestBody Film film) {
    //     // Logic thêm phim vào cơ sở dữ liệu
    //     filmService.addFilm(film);
    //     return ResponseEntity.ok("Film added successfully!");
    // }
}
