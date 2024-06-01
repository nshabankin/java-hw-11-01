package ru.netology.javaqa.javaqamvn.domain;

public class FilmItem { // дата-класс для отдельного фильма

    // поля
    private String filmName; // поле для названия фильма

    // конструкторы
    public FilmItem(String filmName) { // конструктор с названием фильма
        this.filmName = filmName;
    }

    // getters & setters методы
    public String getFilmName() { // getter названия фильма
        return filmName;
    }

    public void setFilmName(String filmName) { // setter названия фильма
        this.filmName = filmName;
    }
}
