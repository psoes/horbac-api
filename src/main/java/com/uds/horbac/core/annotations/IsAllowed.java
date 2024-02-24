package com.uds.horbac.core.annotations;

import com.uds.horbac.core.security.ActivityType;
import com.uds.horbac.core.security.ViewType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IsAllowed {
    ActivityType activity();

    ViewType view();
}
