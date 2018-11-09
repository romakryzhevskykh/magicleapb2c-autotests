package com.magicleap.helpers.models.users;

import com.magicleap.hybris.Cockpit;

import java.util.ArrayList;

public class User {

    private UserTitle userTitle;
    private String legalCompanyName;
    private String dba;
    private String website;
    private String yearsInBusiness;
    private String fullName;
    private String title;
    private String phoneNumber;
    private String streetAddress1;
    private String streetAddress2;
    private String city;
    private String zipCode;
    private String emailToSendInvoice;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private ArrayList<UserRole> userRoles = new ArrayList<>();
    private Cockpit userCockpit;
    private boolean isEnabled;

    public User(String username, String password, Cockpit userCockpit) {
        this.username = username;
        this.password = password;
        this.userCockpit = userCockpit;
        this.isEnabled = true;
    }

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

    public ArrayList<UserRole> getUserRoles() {
        return userRoles;
    }

    public Cockpit getUserCockpit() {
        return userCockpit;
    }

    @Override
    public String toString() {
        return "User: " + this.username + ", Cockpit: " + this.userCockpit.getBaseUrl() + ", Roles: " + this.getUserRoles();
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserTitle getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(UserTitle userTitle) {
        this.userTitle = userTitle;
    }
    public String getLegalCompanyName() {
        return legalCompanyName;
    }
    public void setLegalCompanyName(String legalCompanyName) {
        this.legalCompanyName = legalCompanyName;
    }
    public String getDba() {
        return dba;
    }

    public void setDba(String dba) {
        this.dba = dba;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getYearsInBusiness() {
        return yearsInBusiness;
    }

    public void setYearsInBusiness(String yearsInBusiness) {
        this.yearsInBusiness = yearsInBusiness;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreetAdress1() {
        return streetAddress1;
    }

    public void setStreetAdress1(String streetAdress1) {
        this.streetAddress1 = streetAdress1;
    }

    public String getStreetAdress2() {
        return streetAddress2;
    }

    public void setStreetAdress2(String streetAdress2) {
        this.streetAddress2 = streetAdress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmailToSendInvoice() {
        return emailToSendInvoice;
    }

    public void setEmailToSendInvoice(String emailToSendInvoice) {
        this.emailToSendInvoice = emailToSendInvoice;
    }

    public void setUserRoles(ArrayList<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public void setUserCockpit(Cockpit userCockpit) {
        this.userCockpit = userCockpit;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
