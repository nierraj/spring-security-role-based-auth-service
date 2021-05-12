package com.group.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.entity.Account;
import com.group.entity.AccountStatus;
import com.group.repository.AccountRepository;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@PostMapping("/create")
	public String createAccount(@RequestBody Account account, Principal principal) {
		account.setStatus(AccountStatus.PENDING);
		account.setUserName(principal.getName());
		accountRepository.save(account);
		return principal.getName() + " Your Account created successfully , Required ADMIN/MODERATOR Action !";
	}

	@GetMapping("/approveAccount/{accountId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MODERATOR')")
	public String approveAcount(@PathVariable int accountId) {
		Account account = accountRepository.findById(accountId).get();
		account.setStatus(AccountStatus.APPROVED);
		accountRepository.save(account);
		return "Account Approved !!";
	}

	@GetMapping("/approveAll")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MODERATOR')")
	public String approveAll() {
		accountRepository.findAll().stream().filter(account -> account.getStatus().equals(AccountStatus.PENDING))
				.forEach(account -> {
					account.setStatus(AccountStatus.APPROVED);
					accountRepository.save(account);
				});
		return "Approved all Accounts !";
	}

	@GetMapping("/removeAccount/{AccountId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MODERATOR')")
	public String removeAccount(@PathVariable int accountId) {
		Account account = accountRepository.findById(accountId).get();
		account.setStatus(AccountStatus.REJECTED);
		accountRepository.save(account);
		return "Account Rejected !!";
	}

	@GetMapping("/rejectAll")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MODERATOR')")
	public String rejectAll() {
		accountRepository.findAll().stream().filter(account -> account.getStatus().equals(AccountStatus.PENDING))
				.forEach(account -> {
					account.setStatus(AccountStatus.REJECTED);
					accountRepository.save(account);
				});
		return "Rejected all Accounts !";
	}

	@GetMapping("/viewAll")
	public List<Account> viewAll() {
		return accountRepository.findAll().stream()
				.filter(account -> account.getStatus().equals(AccountStatus.APPROVED)).collect(Collectors.toList());
	}
}
