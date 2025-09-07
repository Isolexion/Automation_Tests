package com.college.link;

import com.college.link.pojos.Account;
import com.college.link.pojos.Currency;
import com.college.link.pojos.Customer;
import com.college.link.pojos.Deposit;

public class DataLoader {     // ο ρόλος της κλάσης αυτής είναι να γυρνά αρχικοποιημένα object

    public Customer loadCustomer(){
        return new Customer("alex", "galano", "33333");
    }

    public Account loadAccount(Customer customer){
        return new Account(customer.getFirstName()+" "+customer.getLastName(), Currency.Dollar);
    }

    public Deposit loadDeposit(){
        return new Deposit("1000");
    }

}
