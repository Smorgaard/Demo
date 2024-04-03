package dev.jkjaer.demo;

class AccountIdNotFoundException extends RuntimeException{
    AccountIdNotFoundException(long id){
        super("Could not find account " + id);
    }
}
