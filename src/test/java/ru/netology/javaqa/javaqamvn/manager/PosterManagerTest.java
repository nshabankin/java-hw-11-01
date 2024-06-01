package ru.netology.javaqa.javaqamvn.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.javaqamvn.domain.FilmItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerTest {

    // объекты элементов массива
    FilmItem item1 = new FilmItem("Бладшот");
    FilmItem item2 = new FilmItem("Вперёд");
    FilmItem item3 = new FilmItem("Отель «Белград»");
    FilmItem item4 = new FilmItem("Джентельмены");
    FilmItem item5 = new FilmItem("Человек-невидимка");
    FilmItem item6 = new FilmItem("Тролли. Мировой тур");
    FilmItem item7 = new FilmItem("Номер один");

    // массив с элементами
    FilmItem[] films = {item1, item2, item3, item4, item5, item6, item7};

    // объекты классов
    PosterManager manager = new PosterManager(); // объект класса менеджера со значениями по умолчанию

    // метод для наполнения менеджера элементами
    @BeforeEach // выполняется перед каждым методом теста
    public void setup() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
    }

    // тест-кейсы

    @Test
    public void shouldAddItem() { // должен добавлять фильмы в массив и выводить все в порядке добавления

        // объект дата-класса для добавления в массив
        FilmItem item8 = new FilmItem("Титаник");

        // тестовое действие
        manager.add(item8);

        // ожидаемый результат
        FilmItem[] expected = {item1, item2, item3, item4, item5, item6, item7, item8};

        // фактический результат
        FilmItem[] actual = manager.findAll();

        // сравнение результатов
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindAll() { // должен выводить все фильмы в порядке добавления

        // ожидаемый результат
        FilmItem[] expected = {item1, item2, item3, item4, item5, item6, item7};

        // фактический результат
        FilmItem[] actual = manager.findAll();

        // сравнение результатов
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithoutLimit() { // должен выводить последние 5 (по умолчанию) фильмов в обратном порядке

        // ожидаемый результат
        FilmItem[] expected = {item7, item6, item5, item4, item3};

        // фактический результат
        FilmItem[] actual = manager.findLast();

        // сравнение результатов
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithLimit() { // должен выводить последние 3 фильма в обратном порядке

        // объект конструктора класса с тестируемым параметром
        PosterManager manager = new PosterManager(3);

        // наполнение нового объекта данными
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);

        // ожидаемый результат
        FilmItem[] expected = {item7, item6, item5};

        // фактический результат
        FilmItem[] actual = manager.findLast();

        // сравнение результатов
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllIfLimitAboveLength() { // должен выводить массив в обратном порядке целиком, если лимит выше длины массива

        // объект конструктора класса с тестируемым параметром
        PosterManager manager = new PosterManager(8);

        // наполнение нового объекта данными
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);

        // ожидаемый результат
        FilmItem[] expected = {item7, item6, item5, item4, item3, item2, item1};

        // фактический результат
        FilmItem[] actual = manager.findLast();

        // сравнение результатов
        assertArrayEquals(expected, actual);
    }
}
