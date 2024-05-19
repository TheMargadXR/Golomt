package com.margad.service.Admin;

import com.margad.model.Admin;
import com.margad.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin saveAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
    }
}
