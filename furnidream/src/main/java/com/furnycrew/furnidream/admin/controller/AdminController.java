package com.furnycrew.furnidream.admin.controller;

import com.furnycrew.furnidream.admin.model.dto.AdminDto;
import com.furnycrew.furnidream.admin.model.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        String adminId = (String) session.getAttribute("adminId");
        model.addAttribute("adminId", adminId);
        if (adminId != null) {
            model.addAttribute("message", adminId + "님, 안녕하세요.");
        } else {
            model.addAttribute("message", "로그인 해주세요.");
        }
        return "index";
    }

    @GetMapping("/success")
    public String login() {
        return "admin/adminSample";
    }

    @PostMapping("/admin/login")
    public String login(HttpServletRequest request, Model model) {
        String adminId = request.getParameter("adminId");
        String adminPw = request.getParameter("adminPw");

        AdminDto admin = adminService.findByAdminId(adminId);
        if (admin != null && admin.getAdminPw().equals(adminPw)) {
            request.getSession().setAttribute("adminId", admin.getAdminId());
            //http://localhost:8080/app/admin/adminSample
            return "redirect:/success";
        } else {
            System.out.println("=====================");
            model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "redirect:/";
        }
    }

    @PostMapping("/admin/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/admin/adminsOnly")
    public String adminsOnly(HttpSession session) {
        if (session.getAttribute("adminId") == null) {
            return "redirect:/admin/login";
        }
        return "admin/adminsOnly";
    }
}