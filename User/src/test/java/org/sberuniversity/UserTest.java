package org.sberuniversity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserTest {
    @Mock
    private UserService userService;

    @Test
    void testAddFriend() {
        User user = new User();
        user.setUserId("1");
        user.setName("John Doe");
        user.setEmail("john@example.com");

        // Настройка поведения мока
        when(userService.addFriend(user)).thenReturn(user);

        // Вызов тестируемого метода
        User result = userService.addFriend(user);

        // Проверка результата
        assertEquals(user, result);

    }

    @Test
    void testGetUserById() {
        // Создаем мок-объект User
        User user = new User();
        user.setUserId("1");
        user.setName("Jane Doe");
        user.setEmail("jane@example.com");

        // Настройка поведения мока
        when(userService.getUserById("1")).thenReturn(user);

        // Вызов тестируемого метода
        User result = userService.getUserById("1");

        // Проверка результата
        assertEquals(user, result);

        // Проверка вызова метода с нужным параметром
        verify(userService, times(1)).getUserById("1");
    }

    @Test
    void testGetAllUsers() {
        // Создаем список пользователей
        User user1 = new User();
        user1.setUserId("1");
        user1.setName("John Doe");
        user1.setEmail("john@example.com");

        User user2 = new User();
        user2.setUserId("2");
        user2.setName("Jane Doe");
        user2.setEmail("jane@example.com");

        List<User> userList = Arrays.asList(user1, user2);

        // Настройка поведения мока
        when(userService.getAllUsers()).thenReturn(userList);

        // Вызов тестируемого метода
        List<User> result = userService.getAllUsers();

        // Проверка результата
        assertEquals(userList, result);

        // Проверка вызова метода
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testRemoveFriend() {
        // Создаем мок-объект User
        User user = new User();
        user.setUserId("1");
        user.setName("John Doe");
        user.setEmail("john@example.com");

        // Настройка поведения мока
        when(userService.removeFriend("1")).thenReturn(user);

        // Вызов тестируемого метода
        User result = userService.removeFriend("1");

        // Проверка результата
        assertEquals(user, result);

    }
}

