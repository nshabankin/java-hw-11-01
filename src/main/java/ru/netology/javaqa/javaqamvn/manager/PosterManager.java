package ru.netology.javaqa.javaqamvn.manager;

import ru.netology.javaqa.javaqamvn.domain.FilmItem;

public class PosterManager { // менеджер для управления афишей

    // поля
    private FilmItem[] films; // поле массива с фильмами
    private int filmLimit; // поле лимита количества фильмов для вывода

    // конструкторы
    public PosterManager() { // конструктор с полями по умолчанию
        this.films = new FilmItem[0]; // поле пустого по умолчанию массива с фильмами
        this.filmLimit = 5; // лимит по умолчанию 5
    }

    public PosterManager(int filmLimit) { // конструктор с возможностью устанавливать лимит фильмов для вывода
        this.films = new FilmItem[0]; // поле пустого по умолчанию массива с фильмами
        this.filmLimit = filmLimit; // замена поля лимита количества фильмов
    }

    // методы
    public void add(FilmItem item) { // метод добавления

        FilmItem[] tmp = new FilmItem[films.length + 1]; // создание нового массива на 1 длиннее

        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i]; // добавление предыдущих элементов во временный массив
        }
        tmp[tmp.length - 1] = item; // добавление нового элемента последним
        films = tmp; // присвоение изначальному массиву временных данных
    }

    public FilmItem[] findAll() { // метод возврата массива с фильмами в порядке добавления
        return films; // возврат массива со списком всех фильмов
    }

    public FilmItem[] findLast() { // метод вывода последних фильмов в обратном порядке в количестве равном лимиту

        int resultLength; // переменная длины массива для вывода

        // вычисление длины массива для вывода
        if (films.length < filmLimit) { // если массив короче лимита,
            resultLength = films.length; // то длина вывода равна длине массива
        } else {
            resultLength = filmLimit; // иначе длина вывода равна лимиту
        }

        // объект массива для вывода
        FilmItem[] result = new FilmItem[resultLength]; // новый массив с вычисленной длиной

        for (int i = 0; i < resultLength; i++) { // цикл по индексам длины массива вывода
            result[i] = films[films.length - 1 - i]; // последние элементы массива в обратном порядке
        }
        return result; // вывод результата
    }
}
