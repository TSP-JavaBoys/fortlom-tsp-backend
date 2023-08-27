package com.example.fortlomtsp.shared.exception;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Message extends Throwable {
    private  String message;

    public Message(String message) {
        this.message = message;
    }
}
