package org.sberuniversity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageTest {

    @Test
    void getMessageTest() {
        MessageService mockMessageService = mock(MessageService.class);
        Message message = new Message();
        message.setContent("Hello!");
        when(mockMessageService.getMessages("user2")).thenReturn(List.of(message));

        List<Message> messages = mockMessageService.getMessages("user2");
        assertEquals("Hello!", messages.get(0).getContent());
    }


    @DisplayName("Объединение 2 модулей")
    @Test
    void testCombinedServicesCreateMessageTest() {
        MessageService mockMessageService = Mockito.mock(MessageService.class);
        UserService mockUserService = Mockito.mock(UserService.class);
        User user1 = new User();
        user1.setEmail("122323@example.com");

        User user2 = new User();
        user2.setUserId("user2");
        user2.setName("Anton");
        user2.setEmail("anton@example.com");

        // Добавляем пользователя
        when(mockUserService.addFriend(user1)).thenReturn(user1);
        when(mockUserService.addFriend(user2)).thenReturn(user2);

        User addedUser1 = mockUserService.addFriend(user1);
        User addedUser2 = mockUserService.addFriend(user2);

        assertNotNull(addedUser1);
        assertNotNull(addedUser2);

        // Создаём сообщение между пользователями
        mockMessageService.createMessage(user1.getUserId(), user2.getUserId(), "Hello !");
        verify(mockMessageService, times(1))
                .createMessage(user1.getUserId(), user2.getUserId(), "Hello from Anton!");
    }
}
