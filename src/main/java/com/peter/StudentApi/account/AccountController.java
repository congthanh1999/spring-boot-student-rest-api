package com.peter.StudentApi.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return accountService.findAllAccounts();
    }

    @PostMapping("/register")
    public ResponseEntity<Object> saveAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }
}
