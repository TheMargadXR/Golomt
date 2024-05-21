package com.margad.service.Users;

import com.margad.model.Users;
import java.util.List;
import com.margad.util.Account;


public interface UsersService {
    public Users saveUsers(Users user);
    public List<Users> getAllUsers();
    Users findByToken(String token);
    int getUserAccountsLength(String token);
    Account findAccountByAccountID(String accountID);

    Users findUserByAccountID(String accountID);
}
