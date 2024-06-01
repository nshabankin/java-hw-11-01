package ru.netology.javaqa.javaqamvn.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmItemTest {

    // объект класса
    FilmItem item = new FilmItem("Титаник");

    // тест-кейсы
    @Test
    public void shouldGetItemName() { // должен возвращать поле названия фильма

        // ожидаемый результат
        String expected = "Титаник";

        // фактический результат
        String actual = item.getFilmName();

        // сравнение результатов
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetItemName() { // должен задавать поле названия фильма

        // тестовое действие
        item.setFilmName("Криминальное чтиво");

        // ожидаемый результат
        String expected = "Криминальное чтиво";

        // фактический результат
        String actual = item.getFilmName();

        // сравнение результатов
        assertEquals(expected, actual);
    }
}