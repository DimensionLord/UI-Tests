package com.karine.context;

import com.karine.pages.Page;
import com.karine.pages.PageTitle;
import org.atteo.classindex.ClassIndex;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class PageManager {
    private static final Map<String, Page> pages = new HashMap<>();

    static {
        for (Class<?> pageClass : ClassIndex.getAnnotated(PageTitle.class)) {
            try {
                pages.put(pageClass.getAnnotation(PageTitle.class).value(), (Page) pageClass.getConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(String.format("Could not create instance for page '%s'", pageClass.getCanonicalName()), e);
            }
        }
    }

    public static Page getPage(String pageTitle) {
        if (!pages.containsKey(pageTitle)) {
            throw new RuntimeException(String.format("No such page '%s'", pageTitle));
        }
        return pages.get(pageTitle);
    }
}
