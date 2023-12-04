package az.unitech.app.controller;

import az.unitech.app.dto.AccountDto;
import az.unitech.app.dto.CurrencyDto;
import az.unitech.app.dto.LoginDto;
import az.unitech.app.dto.UserDto;
import az.unitech.app.service.AccountService;
import az.unitech.app.service.CurrencyService;
import az.unitech.app.service.UserService;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/unitech")
public class UnitechController {

    private final UserService userService;
    private final AccountService accountService;
    private final CurrencyService currencyService;

    @PostMapping("/user/register")
    public void registerUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @PostMapping("/user/login")
    public void login(@RequestBody LoginDto loginDto) {
        userService.login(loginDto);
    }

    @GetMapping("/user/accounts")
    public List<AccountDto> getAccounts() {
        return accountService.getActiveUserAccounts();
    }

    @GetMapping("/account/transfer")
    public void transferToAccount(String accNumber, BigDecimal amount) {
         accountService.transferToAccount(accNumber, amount);
    }

    @GetMapping("/currencies")
    public List<CurrencyDto> getCurrencies() {
        return currencyService.getCurrencies();
    }

}
