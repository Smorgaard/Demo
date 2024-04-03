package dev.jkjaer.demo;


import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id; 



@Entity
class Account{
    private @Id @GeneratedValue Long id;
    private double balance = 0.0;
    private String first_name;
    private String last_name;

    Account() {}

    Account(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }
    public Long getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.first_name;
    }

    public String getLastName(){
        return this.last_name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void depositMoney(double money){
        this.balance += money;
    }


    @Override
    public boolean equals(Object o) {

    if (this == o)
        return true;
    if (!(o instanceof Account))
        return false;
        Account account = (Account) o;
    return Objects.equals(this.id, account.id) 
        && Objects.equals(this.balance, account.balance)
        && Objects.equals(this.first_name, account.first_name)
        && Objects.equals(this.last_name, account.last_name);

  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.balance, this.first_name, this.last_name);
  }

  @Override
  public String toString() {
    return "Account{" + "Account number=" + this.id + ", Balance='" + this.balance + '\'' + ", First name='" + this.first_name + '\'' + ", First name='" + this.first_name + '\'' + '}';
  }
}


