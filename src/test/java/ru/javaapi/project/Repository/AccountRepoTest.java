package ru.javaapi.project.Repository;

import org.junit.Before;
import org.junit.Test;
import ru.javaapi.project.Model.Account;

import static org.junit.Assert.*;

public class AccountRepoTest {

    private AccountRepo accountRepo;

    @Before
    public void setUp() throws Exception {
        this.accountRepo =  new AccountRepo();
    }

    @Test
    public void findAccountByLoginNotNull() {
        // если мы только точно уверенны, что такой пользователь есть, к примеру какой-то тестовый пользователь
        Account account = new Account("Sasha", "Ivanov");
        Account accountFound = accountRepo.findAccountByLogin(account.getLogin());

        assertNotNull(accountFound);
        assertEquals(account.getLogin(), accountFound.getLogin());
        assertEquals(account.getLastName(), accountFound.getLastName());
    }

    @Test
    public void findAccountByLoginNull() {
        Account accountFound = accountRepo.findAccountByLogin("565");
        assertNull(accountFound);
    }

    @Test
    public void editAccountInfo() {
        String login = "Pavel";
        accountRepo.editAccountInfo(login, "Koshechkin");
        Account accountEdited = accountRepo.findAccountByLogin(login);

        assertNotNull(accountEdited);
        assertEquals("Koshechkin", accountEdited.getLastName());
        assertEquals(login, accountEdited.getLogin());

    }
}