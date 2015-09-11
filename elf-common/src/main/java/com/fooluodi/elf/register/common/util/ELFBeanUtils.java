package com.fooluodi.elf.register.common.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by di on 7/8/15.
 */
public class ElfBeanUtils {
    /**
     * 验证传入对象是有含有null的属性
     *
     * @param bean
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static List<String> detectNullFields(Object bean) throws IllegalArgumentException, IllegalAccessException {
        List fields = getFieldsUpTo(bean.getClass(), Object.class);
        ArrayList nullFields = new ArrayList();
        Iterator var4 = fields.iterator();

        while(var4.hasNext()) {
            Field f = (Field)var4.next();
            f.setAccessible(true);
            Object value = f.get(bean);
            if(value == null) {
                nullFields.add(f.getName());
            }
        }

        return nullFields;
    }

    public static List<Field> getFieldsUpTo(Class<?> startClass, Class<?> exclusiveParent) {
        List currentClassFields = toList(startClass.getDeclaredFields());
        Class parentClass = startClass.getSuperclass();
        if(parentClass != null && (exclusiveParent == null || !parentClass.equals(exclusiveParent))) {
            List parentClassFields = getFieldsUpTo(parentClass, exclusiveParent);
            currentClassFields.addAll(0, parentClassFields);
        }

        return currentClassFields;
    }

    public static <T> List<T> toList(T[] array) {
        if(array == null) {
            return Collections.emptyList();
        } else {
            ArrayList list = new ArrayList();

            for(int i = 0; i < array.length; ++i) {
                list.add(array[i]);
            }

            return list;
        }
    }

    /**
     * 如果字符串是null，则返回""
     * @param s
     * @return
     */
    public static String killNull(String s) {
        return s == null?"":s;
    }
}
