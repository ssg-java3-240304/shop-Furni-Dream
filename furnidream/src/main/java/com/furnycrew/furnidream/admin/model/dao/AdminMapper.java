package com.furnycrew.furnidream.admin.model.dao;

import com.furnycrew.furnidream.admin.model.dto.AdminDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
    AdminDto findAdminByIdAndPassword(@Param("adminId") String adminId, @Param("adminPw") String adminPw);
}
