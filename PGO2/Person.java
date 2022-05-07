package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;


public class Person {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private Address address;
    public LocalDate current_date = LocalDate.now();
    public int currentYear = current_date.getYear();

    public Person(String name, String surname, LocalDate dateOfBirth, Address address) {
        setName(name);
        setSurname(surname);
        setDateOfBirth(dateOfBirth);
        setAddres(address);
    }

    public Person(String name, String surname) {
        setName(name);
        setSurname(surname);

    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        if (n == null || n.isEmpty()) {
            throw new ValidationException("Name cannot be empty");
        }
        this.name = n;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String sur) {
        if (sur == null || sur.isEmpty()) {
            throw new ValidationException("Surname cannot be empty");
        }
        this.surname = sur;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth.equals(null)) {
            throw new ValidationException("Date of birth cannot be empty");
        } else {
            this.dateOfBirth = dateOfBirth;
        }
    }

    public int getPersonAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public String getAddress() {
        return address.getCountry() + " " + address.getCity() + " " + address.getStreet() + " " + address.getHouse() + " "
                + address.getFlat();
    }

    public void setAddres(Address addres) {
        if (addres == null) {
            throw new ValidationException("address cannot be empty");
        }
        this.address = addres;
    }

    public Book PublishBook(String name, Genre genre, Language language, LocalDate pubDate, Person author) {
        ArrayList<Person> authors = new ArrayList<Person>();
        authors.add(this);
        Book bk = new Book(name, genre, language, pubDate, authors);
        bk.setPublishDate(pubDate);
        return bk;
    }
}