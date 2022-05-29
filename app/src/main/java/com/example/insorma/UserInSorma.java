package com.example.insorma;

public class UserInSorma {
    Integer idUser;
    String userName;
    String userEmailAddress;
    String userPhoneNumber;
    String userPassword;

    public UserInSorma(Integer idUser, String userName, String userEmailAddress, String userPhoneNumber, String userPassword) {
        this.idUser = idUser;
        this.userName = userName;
        this.userEmailAddress = userEmailAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.userPassword = userPassword;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
