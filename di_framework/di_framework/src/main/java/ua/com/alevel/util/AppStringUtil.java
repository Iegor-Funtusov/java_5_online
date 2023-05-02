package ua.com.alevel.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class AppStringUtil {

    private static final String CAMEL_CASE_REGEX = "(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])";

    private AppStringUtil() {}

    public static String convertCamelCaseStyleToSnakeCase(String text) {
        return Stream.of(text.split(CAMEL_CASE_REGEX)).map(String::toLowerCase).collect(Collectors.joining("_"));
    }
}
