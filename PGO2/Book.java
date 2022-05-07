package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Book {
    private static Set<Book> extent = new HashSet<>();

    private Long ID;
    private String name;
    private Genre genre;
    private Language language;
    private LocalDate publishDate;
    private int borrowCount;
    private boolean isAvailable = true;
    private String whoBorrowed;
    private List<Person> authors = new ArrayList<>();
    
    public Book(Long ID, String name, Genre genre, Language language, LocalDate publishDate, List<Person> authors,
                boolean isAvailable) {
        setID(ID);
        setName(name);
        setGenre(genre);
        setLange(language);
        setPublishDate(publishDate);
        setBorrowCount(borrowCount);
        setIsAvailable(isAvailable);
        for (Person author : authors) {
            setAuthor(author);
        }
        extent.add(this);
    }

    public Book(Long ID, String name, Genre genre, Language language, LocalDate publishDate, int borrowCount) {
        setID(ID);
        setName(name);
        setGenre(genre);
        setLange(language);
        setPublishDate(publishDate);
        setBorrowCount(borrowCount);
    }

    public Book(String name, Genre genre, Language language, LocalDate publishDate, ArrayList<Person> authors) {
        setName(name);
        setGenre(genre);
        setLange(language);
        setPublishDate(publishDate);
        for (Person author : authors) {
            setAuthor(author);
        }
        extent.add(this);
    }

    public void setAuthor(Person author) {
        this.authors.add(author);
    }
    
    public Long getID() {
        return ID;
    }

    public void setID(Long id) {
        if (id == null || id < 0) {
            throw new ValidationException("ID cannot be empty and cannot be less than 0");
        }
        this.ID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new ValidationException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getwhoBorrowed() {
        return this.whoBorrowed;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public void setGenre(Genre genre) {
        if (genre == null) {
            throw new ValidationException("Genre cannot be empty");
        }
        this.genre = genre;
    }

    public Language getLange() {
        return language;
    }

    public void setLange(Language language) {
        if (language == null) {
            throw new ValidationException("Book Language cannot be empty");
        }
        this.language = language;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        if (publishDate == null) {
            throw new ValidationException("Publish date is unknow");
        }
        this.publishDate = publishDate;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(int borrowCount) {
        if (borrowCount != 1) {
            throw new ValidationException("You can borrow only 1 book at a time");
        }
        this.borrowCount = borrowCount;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        if (isAvailable != true || isAvailable != false) {
            throw new ValidationException("it has to be true or false");
        }
        this.isAvailable = isAvailable;
    }
    
    public int getBookAge() {
        return Period.between(publishDate, LocalDate.now()).getYears();
    }

    public void BorrowBook(Person who) {
        if (getIsAvailable() == false) {
            System.out.println("This book is not available");
        } else {
            this.borrowCount += 1;
            isAvailable = false;
            whoBorrowed = who.getName();
            System.out.println("This book is borrowed by " + who.getName());
        }
    }

    public void PlaceBack() {
        this.isAvailable = true;
        System.out.print("Book:" + getName() + " is now available");
        whoBorrowed = null;
    }

}