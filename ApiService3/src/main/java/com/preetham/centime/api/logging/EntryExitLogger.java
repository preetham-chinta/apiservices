package com.preetham.centime.api.logging;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import org.aspectj.lang.annotation.Pointcut;

@Retention(RUNTIME)
@Target({ METHOD })
public @interface EntryExitLogger {
}
