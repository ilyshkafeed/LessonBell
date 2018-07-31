package Utilites;

import java.lang.reflect.Field;

public class SetField {
    public static void set(Object object, String fieldName, Object value) {
        try {
            Field f = object.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            f.set(object, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
