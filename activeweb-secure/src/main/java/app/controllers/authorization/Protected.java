package app.controllers.authorization;

import java.lang.annotation.*;

/**
 * Annotation for controllers that need to be protected by password
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Protected {}