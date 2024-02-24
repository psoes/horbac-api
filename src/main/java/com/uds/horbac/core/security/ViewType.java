package com.uds.horbac.core.security;

import lombok.Getter;

@Getter
public enum ViewType {
    ORGANIZATIONS(1, "ORGANIZATIONS"), UNITS(2, "UNITS"), EMPLOYEES(3, "EMPLOYEES"),
    ACTIVITY(4, "ACTIVITY"), VIEWS(5, "VIEWS"), PERMISSIONS(6, "PERMISSIONS"), RESOURCES(7, "RESOURCES"),
    ACTIONS(8, "ACTIONS"), CONTEXTS(9, "CONTEXTS"), POLICY_DATABASE(10, "POLICY_DATABASE");

    private final long code;
    private final String name;

    ViewType(long code, String name) {
        this.code = code;
        this.name = name;
    }

}
