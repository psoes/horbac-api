package com.uds.horbac.core.security;

import lombok.Getter;

@Getter
public enum ActivityType {

    CREATE(1, "CREATE"),
    UPDATE(2, "UPDATE"),
    DELETE(3, "DELETE"),
    VIEW(4, "VIEW"),
    ADMINISTER(5, "ADMINISTER");

    private final long code;
    private final String name;

    ActivityType(long code, String name) {
        this.code = code;
        this.name = name;
    }
}
