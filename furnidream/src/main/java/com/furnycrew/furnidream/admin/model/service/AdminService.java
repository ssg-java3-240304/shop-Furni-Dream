package com.furnycrew.furnidream.admin.model.service;

import com.furnycrew.furnidream.admin.model.dao.AdminMapper;
import com.furnycrew.furnidream.admin.model.dto.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Transactional
    public AdminDto findByAdminId(String adminId) {
        return adminMapper.findByAdminId(adminId);
    }
}
