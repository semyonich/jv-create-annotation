package core.basesyntax.lib;

import core.basesyntax.exceptions.NoDaoAnnotationExeption;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        if (clazz.getAnnotation(Dao.class) == null) {
            throw new NoDaoAnnotationExeption("There is no @Dao annotation above classname "
                    + clazz);
        }
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field: declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getName().equals("betDao")) {
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getName().equals("userDao")) {
                    field.set(instance, Factory.getUserDao());
                }
            }
        }
        return instance;
    }
}
