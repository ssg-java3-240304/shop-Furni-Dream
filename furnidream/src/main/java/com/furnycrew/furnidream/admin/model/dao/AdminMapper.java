package com.furnycrew.furnidream.admin.model.dao;

import com.furnycrew.furnidream.admin.model.dto.AdminDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    AdminDto findByAdminId(String adminId);
}
