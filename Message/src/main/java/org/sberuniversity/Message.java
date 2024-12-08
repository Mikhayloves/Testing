package org.sberuniversity;

import lombok.Data;

@Data
public class Message {
        private String fromUserId;
        private String toUserId;
        private String content;
}


