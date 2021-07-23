package ru.javaapi.project.Repository;

import org.junit.Test;
import ru.javaapi.project.Model.Account;

import static org.junit.Assert.*;

public class AccountRepoTest {

    private AccountRepo accountRepo = new AccountRepo();
    private final Account account = new Account("Sasha", "Ivanov");

    @Test
    public void findAccountByLogin() {

        Account accountFound = accountRepo.findAccountByLogin(account.getLogin());
        assertNotNull(accountFound.getLogin(), accountFound.getLastName());
        assertEquals(account.getLogin(), accountFound.getLogin());
        assertEquals(account.getLogin(), accountRepo.findAccountByLogin(account.getLogin()).getLogin());

        Account accountNull = accountRepo.findAccountByLogin("565");
        assertNull(accountNull.getLogin(), accountNull.getLastName());

    }

    @Test
    public void editAccountInfo() {

        accountRepo.editAccountInfo(account.getLogin(), "Pupkin");
        Account accountEdited = accountRepo.findAccountByLogin(account.getLogin());

        assertNotNull(accountEdited.getLastName(), accountEdited.getLastName());
        assertEquals("Pupkin", accountEdited.getLastName());
        assertEquals(account.getLogin(), accountEdited.getLogin());

    }
}