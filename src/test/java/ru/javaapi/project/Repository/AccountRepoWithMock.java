package ru.javaapi.project.Repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.javaapi.project.Model.Account;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class AccountRepoWithMock {

    @Mock
    private AccountRepo accountRepo;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAccountByLoginNotNullAndTrue() {
        String login = "Sasha";
        String lastname = "Pupkin";

        given(accountRepo.findAccountByLogin(login)).willReturn(new Account(login, lastname));
        Account account = accountRepo.findAccountByLogin(login);
        assertNotNull(account);
        assertEquals(login, account.getLogin());
        assertEquals(lastname, account.getLastName());

        verify(accountRepo,times(1)).findAccountByLogin(login);
    }

    @Test
    public void findAccountByLoginNullAndFalse() {
        given(accountRepo.findAccountByLogin("565")).willReturn(null);

        Account account = accountRepo.findAccountByLogin("565");
        assertNull(account);

        verify(accountRepo,times(1)).findAccountByLogin("565");
    }

    @Test
    public void editAccountInfo() {
        String login = "Pavel";
        String newLastname = "Koshechkin";

        // выполняем метод на обновление фамилии у пользователя
        accountRepo.editAccountInfo(login, newLastname);
        verify(accountRepo,times(1)).editAccountInfo(login, newLastname);

        // проверяем, что фамилия обновилась
        given(accountRepo.findAccountByLogin(login)).willReturn(new Account(login, newLastname));
        Account account = accountRepo.findAccountByLogin(login);
        assertNotNull(account);
        assertEquals(login, account.getLogin());
        assertEquals(newLastname, account.getLastName());
    }

}
