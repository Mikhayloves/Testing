package org.sberuniversity;

import java.util.List;

public interface UserService {
    User addFriend(User user);
    User getUserById(String userId);
    List<User> getAllUsers();
    User removeFriend(String userId);
}
