package ru.javaapi.project.Model;

public class Account {

    //класс создан специально для тестового задания

    //login назван, потому что он обычно уникальный, в задании написано "имя УЗ — уникальный атрибут"
    private String login;
    private String lastName;

    public Account() {

    }

    public Account(String login, String lastName) {
        this.login = login;
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
