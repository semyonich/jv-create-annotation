package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exceptions.NoDaoAnnotationExeption;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field: declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)) {
                    if (Factory.getBetDao().getClass().getAnnotation(Dao.class) == null) {
                        throw new NoDaoAnnotationExeption("There is no @Dao annotation above "
                    + Factory.getBetDao().getClass());
                    }
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getType().equals(UserDao.class)) {
                    if (Factory.getUserDao().getClass().getAnnotation(Dao.class) == null) {
                        throw new NoDaoAnnotationExeption("There is no @Dao annotation above "
                                + Factory.getUserDao().getClass());
                    }
                    field.set(instance, Factory.getUserDao());
                }
            }
        }
        return instance;
    }
}
