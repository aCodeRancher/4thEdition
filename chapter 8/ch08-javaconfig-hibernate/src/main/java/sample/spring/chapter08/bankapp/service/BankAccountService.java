package sample.spring.chapter08.bankapp.service;

import sample.spring.chapter08.bankapp.domain.BankAccountDetails;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BankAccountService {
	int createBankAccount(BankAccountDetails bankAccountDetails);
}
