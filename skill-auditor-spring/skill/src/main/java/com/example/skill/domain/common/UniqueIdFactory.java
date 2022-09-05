package com.example.skill.domain.common;

import java.util.UUID;

public class UniqueIdFactory {
    public static Identity createId(){
        return new Identity(UUID.randomUUID().toString());
    }
}
