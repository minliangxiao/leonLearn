package com.example.alip6.bean;

public class UserEntity {
    private String userName;
    private Integer userAge;

    public String pubUserName;

    public UserEntity(String userName, Integer userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }

    public UserEntity() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getPubUserName() {
        return pubUserName;
    }

    public void setPubUserName(String pubUserName) {
        this.pubUserName = pubUserName;
    }

    private void gowpYb(){
        System.out.println("hellow gowpYb");
    }

    private Integer sum(Integer a,Integer b){
        return a+b;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", pubUserName='" + pubUserName + '\'' +
                '}';
    }
}
