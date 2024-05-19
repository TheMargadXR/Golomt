package com.margad.service.Users;

import com.margad.model.Users;
import java.util.List;

public interface UsersService {
    public Users saveUsers(Users user);
    public List<Users> getAllUsers();
}
