package com.college.link.pojos;

public class Customer {

    String firstName;
    String lastName;
    String postCode;

    public Customer(String firstName, String lastName, String postCode ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.postCode = postCode;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getPostCode(){
        return postCode;
    }

    public void setPostCode(String postCode){
        this.postCode = postCode;
    }
}
