package com.margad.service.Users;

import com.margad.model.Users;
import com.margad.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.margad.util.Account;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users saveUsers(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
    @Override
    public Users findByToken(String token) {
        return usersRepository.findByToken(token);
    }
    @Override
    public int getUserAccountsLength(String token) {
        Users user = usersRepository.findByToken(token);  // Or use findByToken or another method
        if (user != null && user.getAccounts() != null) {
            return user.getAccounts().size();
        }
        return 0;
    }

    @Override
    public Users findUserByAccountID(String accountID) {
        List<Users> usersList = usersRepository.findAll();
        for (Users user : usersList) {
            List<Account> accounts = user.getAccounts();
            if (accounts != null) {
                for (Account account : accounts) {
                    if (accountID.equals(account.getAccountID())) {
                        return user;
                    }
                }
            }
        }
        return null;
    }
}
