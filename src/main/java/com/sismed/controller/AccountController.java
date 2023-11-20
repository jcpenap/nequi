package com.sismed.controller;

import com.sismed.domain.Account;
import com.sismed.request.AccountRequest;
import com.sismed.service.AccountService;
import com.sismed.util.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Account>> create(@Valid @RequestBody AccountRequest request) {
        return ResponseEntity.ok(new Response<>(accountService.create(request), "Authorized"));
    }

    @PutMapping("/{id}/withdraw")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Response<Account>> withdraw(@PathVariable("id") Long id, @Valid @RequestBody AccountRequest request) {
        return ResponseEntity.ok(new Response<>(accountService.withdraw(id, request), "Authorized"));
    }

    @PutMapping("/{id}/deposit")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Response<Account>> deposit(@PathVariable("id") Long id, @Valid @RequestBody AccountRequest request) {
        return ResponseEntity.ok(new Response<>(accountService.deposit(id, request), "Authorized"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Long id) {
        accountService.delete(id);
    }
}
