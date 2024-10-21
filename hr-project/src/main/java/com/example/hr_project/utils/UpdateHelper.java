package com.example.hr_project.utils;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class UpdateHelper {
    public static <T> void updateField(Supplier<T> getter, Consumer<T> setter, T newValue) {
        if (newValue != null && !(newValue instanceof String && ((String) newValue).isEmpty())) {
            setter.accept(newValue);
        }
    }
}
