package org.example.cloneboot;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class CloneApplication {
    private final ResourceLoader resourceLoader;
    private final Set<Class<?>> primarySources;

    public CloneApplication(Class<?>... primarySources) {
        this(null, primarySources);
    }

    public CloneApplication(ResourceLoader resourceLoader, Class<?>... primarySources) {
        this.resourceLoader = resourceLoader;
        Assert.notNull(primarySources, "PrimarySources must not be null");
        this.primarySources = new LinkedHashSet<>(Arrays.asList(primarySources));
    }

    public static ConfigurableApplicationContext run(String... args) {
        return new GenericApplicationContext();
    }

    public static ConfigurableApplicationContext run(Class<?>[] primarySources, String... args) {
        return new CloneApplication(primarySources).run(args);
    }

    public static ConfigurableApplicationContext run(Class<?> primarySource, String... args) {
        return run(new Class<?>[]{primarySource}, args);
    }
}
