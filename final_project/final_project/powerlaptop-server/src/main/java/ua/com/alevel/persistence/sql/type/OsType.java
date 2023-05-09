package ua.com.alevel.persistence.sql.type;

import lombok.Getter;

@Getter
public enum OsType {

    WINDOWS("Windows"),
    LINUX("Linux"),
    MAC_OS("Mac OS");

    private final String type;

    OsType(String type) {
        this.type = type;
    }
}
