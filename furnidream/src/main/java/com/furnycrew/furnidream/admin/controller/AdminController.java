package com.furnycrew.furnidream.admin.controller;

import com.furnycrew.furnidream.admin.model.dto.AdminDto;
import com.furnycrew.furnidream.admin.model.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AdminController {
    @Autowired
    private final AdminService adminService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("adminId") == null) {
            return "redirect:/admin/login";
        }
        String adminId = (String) session.getAttribute("adminId");
        model.addAttribute("message", adminId + "님, 안녕하세요🦄");
        return "index";
    }

    @GetMapping("/admin/login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("/admin/login")
    public String login(@RequestParam("adminId") String adminId, @RequestParam("adminPw") String adminPw, HttpServletRequest request, Model model) {
        AdminDto admin = adminService.login(adminId, adminPw);
        if (admin != null) { // 로그인 성공
            HttpSession session = request.getSession();
            session.setAttribute("adminId", admin.getAdminId());
            return "redirect:/";
        } else { // 로그인 실패
            model.addAttribute("error", "로그인 실패. 관리자 ID 또는 비밀번호를 확인하세요.");
            return "admin/login";
        }
    }

    @PostMapping("/admin/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/admin/login";
    }
}