package org.sberuniversity;

import java.util.List;

public interface MessageService {
    void createMessage(String fromUserId, String toUserId, String content);
    List<Message> getMessages(String userId);
}
