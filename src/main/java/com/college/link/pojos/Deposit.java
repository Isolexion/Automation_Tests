package com.college.link.pojos;

public class Deposit {

    String amount;

    public Deposit(String amount){
        this.amount = amount;
    }

    public String getAmount(){
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
