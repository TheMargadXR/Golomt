package com.margad.service.Admin;

import com.margad.model.Admin;

import java.util.List;

public interface AdminService {
    public Admin saveAdmin(Admin admin);
    public List<Admin> getAllAdmin();
}
