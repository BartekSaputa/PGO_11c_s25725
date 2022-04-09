package com.company;

import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {
    Book book1 = new Book(1L, "Harry Potter and the Philosopher’s Stone", Genre.Fantasy, Lang.English, LocalDate.of(1997, 6, 26), 1);
    Person person1 = new Person("Harry", "Maguire", LocalDate.of(1993, 10, 1),
        new Adress("Poland", "Warsaw", "Jana Kazimierza", 122, 7));
    Person person2 = new Person("Paul", "Pogba", LocalDate.of(2003, 12, 7),
        new Adress("Poland", "Lublin", "Warszawska", 2, 34));

    System.out.println("Person age " + person1.getPersonAge());
    System.out.println("Book age " + book1.getBookAge());
    System.out.println(person1.getAdress());
    book1.BorrowBook(person1);
    book1.BorrowBook(person2);
    Book book2 = person1.PublishBook("Harry Potter and the Chamber of Secrets", Genre.Fantasy, Lang.Polish,
        LocalDate.of(1992, 10, 2), new Person("David", "De Gea"));
    System.out.println(book2.getName());
    System.out.println("this book is borrow by: " + book1.getwhoBorrowed());
    book1.PlaceBack();

  }
}