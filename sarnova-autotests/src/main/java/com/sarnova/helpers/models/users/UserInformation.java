package com.sarnova.helpers.models.users;

import com.sarnova.storefront.pages.DefaultHomePage;

public class UserInformation {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private com.sarnova.helpers.models.users.Title title;
    private String accountLabel;
    private String phoneNumber;
    private String email;
    private DefaultHomePage defaultHomePage;
    private SecurityQuestion securityQuestion;
    private String securityAnswer;
    private AccountType accountType;
    private ProfileRole profileRole;
    private boolean someoneToMakePurchase;
    private boolean receiveEmails;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getAccountLabel() {
        return accountLabel;
    }

    public void setAccountLabel(String accountLabel) {
        this.accountLabel = accountLabel;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DefaultHomePage getDefaultHomePage() {
        return defaultHomePage;
    }

    public void setDefaultHomePage(DefaultHomePage defaultHomePage) {
        this.defaultHomePage = defaultHomePage;
    }

    public SecurityQuestion getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(SecurityQuestion securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public ProfileRole getProfileRole() {
        return profileRole;
    }

    public void setProfileRole(ProfileRole profileRole) {
        this.profileRole = profileRole;
    }

    public boolean isSomeoneToMakePurchase() {
        return someoneToMakePurchase;
    }

    public void setSomeoneToMakePurchase(boolean someoneToMakePurchase) {
        this.someoneToMakePurchase = someoneToMakePurchase;
    }

    public boolean isReceiveEmails() {
        return receiveEmails;
    }

    public void setReceiveEmails(boolean receiveEmails) {
        this.receiveEmails = receiveEmails;
    }
}
