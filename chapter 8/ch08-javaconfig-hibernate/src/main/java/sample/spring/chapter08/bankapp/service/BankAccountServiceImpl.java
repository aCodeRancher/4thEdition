package sample.spring.chapter08.bankapp.service;


import org.springframework.transaction.interceptor.TransactionInterceptor;
import sample.spring.chapter08.bankapp.dao.BankAccountDao;
import sample.spring.chapter08.bankapp.domain.BankAccountDetails;

public class BankAccountServiceImpl implements BankAccountService {

	private BankAccountDao bankAccountDao;

	public void setBankAccountDao(BankAccountDao bankAccountDao) {
		this.bankAccountDao = bankAccountDao;
	}
	
	@Override
	public int createBankAccount(BankAccountDetails bankAccountDetails) {
		System.out.println(" in create bank account, current trans status:" + TransactionInterceptor.currentTransactionStatus());
		return bankAccountDao.createBankAccount(bankAccountDetails);
	}

}
