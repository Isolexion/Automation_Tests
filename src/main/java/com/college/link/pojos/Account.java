package com.college.link.pojos;

public class Account {

    String customerName;
    Currency currency;                 //είναι τύπου Currency απο το enam Currency

    public Account(String customerName, Currency currency){
        this.customerName = customerName;
        this.currency = currency;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public Currency getCurrency(){
        return currency;
    }

    public void setCurrency(Currency currency){
        this.currency = currency;
    }
}


