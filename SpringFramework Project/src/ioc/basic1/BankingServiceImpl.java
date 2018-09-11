package ioc.basic1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class BankingServiceImpl implements BankingService, BeanFactoryAware {
	
	private BankingDao dao;
	
	private Map<String, Account> accountList = null;
	
	public void initializeAccountList ( ) {
		this.accountList = new HashMap<String, Account> ( );
		System.out.println( "Account List has been initialized." );
	}
	
	public void releaseAccountList ( ) {
		this.accountList = null;
		System.out.println( "Memory allocated to Account List has been released." );
	}
	
	public BankingDao getDao() {
		return dao;
	}

	public void setDao(BankingDao dao) {
		this.dao = dao;
	}

	@Override
	public void deposit(double amount) {
		dao.retrieveAccount( "CS001" );
		dao.updateAccount( amount );
		System.out.println( "$" + amount + " has been deposited into your account." );
	}

	@Override
	public void withdraw(double amount) {
		dao.retrieveAccount( "CS001" );
		dao.updateAccount( -amount );
		System.out.println( "$" + amount + " has been taken from your account." );
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println( "I've found \"" + beanFactory.containsBean( "dbConnector1") + "\" in the bean factory.");
		
	}

	@Override
	public void createAccount(Account account) {
		this.accountList.put(account.getAccountNumber(), account);
		System.out.println( "Account ( " + account.getAccountNumber() + "/" + account.getAccountName() + " / " + account.getBalance() + " ) has been created." );
		
	}
	
	@Override
	public void printAllAccounts() {

		System.out.println( "Account List" );
		for ( Account account: this.accountList.values() ) {
			System.out.println( "Account: " + account.getAccountNumber() + "/" + account.getAccountName() + " / " + account.getBalance() );
		}
		
	}

}
