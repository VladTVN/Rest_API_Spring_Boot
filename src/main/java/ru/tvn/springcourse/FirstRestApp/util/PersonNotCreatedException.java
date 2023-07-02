package ru.tvn.springcourse.FirstRestApp.util;

public class PersonNotCreatedException extends Exception{
    public PersonNotCreatedException(String message) {
        super(message);
    }
}
