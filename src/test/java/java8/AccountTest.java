package java8;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.google.common.collect.*;
import java.util.*;
import org.junit.*;
import static java8.Java8.*;
import static org.junit.Assert.*;


public class AccountTest {

	@Test
	public void equality(){
		Account accountBOF = new Account("bof", 1111111, 100);
		Account accountBOF2 = new Account("bof", 1111111, 10);
		assertTrue(accountBOF.equals(accountBOF2));
	}


	@Test
	public void minusAccounts(){
		Account accountBOF = new Account("bof", 1111111, 100);
		Account accountBOF2 = new Account("bof", 1111111, 10);
		Account accountBC = new Account("bancoChicle", 1111112, 1145);
		Account accountBE = new Account("bancoEstadio", 1111122, 114590);

		assertTrue(accountBOF.equals(accountBOF2));

		List<Account> previousAccounts = new ArrayList<>();
		previousAccounts.add(accountBOF);
		previousAccounts.add(accountBE);

		List<Account> currentAccounts = new ArrayList<>();	
		currentAccounts.add(accountBOF2);	
		currentAccounts.add(accountBC);	

		Account.checkOldAccounts(previousAccounts, currentAccounts);

		assertTrue(previousAccounts.contains(accountBE));
		assertFalse(previousAccounts.contains(accountBC));
	}
}