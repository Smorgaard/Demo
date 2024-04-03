package dev.jkjaer.demo;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
class AccountController {

    private final AccountRepository repository;

    AccountController(AccountRepository repository){
        this.repository = repository;
    }


    @GetMapping("/accounts")
    List<Account> all(){
        return repository.findAll();
    }

    @PostMapping("/accounts")
    String newAccount(@RequestBody Account newAccount) {
        
        return repository.save(newAccount);
    }

    @GetMapping("/account/{id}")
    Account one(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new AccountIdNotFoundException(id));
    }

    @PutMapping("/account/{id}/deposit")
    Account depositMoney(@PathVariable long id, @RequestBody double cash) {
        return repository.findById(id)
            .map(account -> {
                account.depositMoney(cash);
                return repository.save(account);
            })
            .orElseThrow(() -> new AccountIdNotFoundException(id));
    }
    
    
}
