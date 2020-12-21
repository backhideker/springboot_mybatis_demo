package com.spring.demo.entity;


import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Component;

@Component

public class otherUser {
    private String name;
    private String fk;
    public otherUser(String name,String fk){
        this.name=name;
        this.fk=fk;
    }

}
