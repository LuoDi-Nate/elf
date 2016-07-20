package com.fooluodi.elf.common.util.validate.function;

import com.fooluodi.elf.common.util.validate.ValidateException.ValidateException;
import com.fooluodi.elf.common.util.validate.annotation.Max;
import com.fooluodi.elf.common.util.validate.annotation.Min;
import com.fooluodi.elf.common.util.validate.annotation.NotNull;
import com.fooluodi.elf.common.util.validate.function.handlers.AbstractHandler;
import com.fooluodi.elf.common.util.validate.function.handlers.MaxHandler;
import com.fooluodi.elf.common.util.validate.function.handlers.NotNullHandler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by di on 19/7/2016.
 */
public class ValidateHelper {
    /**
     * default value
     */
    private static final ValidateException DEFAULT_EXCEPTION = new ValidateException();
    private static final boolean DEFAULT_IS_DEEP = false;
    private static final boolean DEFAULT_FORCE_EXCEPTION = false;

    private static final ValidateException NULL_EXCEPTION = new ValidateException("Target can not be null!");

    /**
     * effective annotations
     */
    private static final List<Class> effectiveAnnos = new ArrayList<Class>(Arrays.asList(
            Max.class,
            Min.class,
            NotNull.class
    ));

    /**
     * register handlers
     */
    private static final Map<Class, AbstractHandler> handlers = new HashMap<Class, AbstractHandler>();

    static {
        handlers.put(Max.class, new MaxHandler());
        handlers.put(NotNull.class, new NotNullHandler());
    }

    public static <T, E extends Throwable> void validate(T dto) {
        validate(dto, DEFAULT_IS_DEEP);
    }

    public static <T, E extends Throwable> void validate(T dto, boolean isDeep) {
        validate(dto, isDeep, DEFAULT_FORCE_EXCEPTION, DEFAULT_EXCEPTION);
    }

    /**
     * 用于校验传入dto是否满足validate条件
     *
     * @param bean           待检查的bean
     * @param isDeep         是否需要深度检查, 适用于List, Map, Set 等
     * @param forceException 是否要自定义异常
     * @param exception      传入的自定义异常
     * @param <T>            Bean本身
     * @param <E>            自定义异常
     */
    public static <T, E extends RuntimeException> void validate(T bean, boolean isDeep, boolean forceException, E exception) {
        validateNull(bean, isDeep, forceException, exception);

        //根据effectiveAnnos 遍历bean的field 按照effectiveAnnos归类
        Map<Class, Set<Field>> classSetMap = new HashMap<Class, Set<Field>>();

        for (Class effectiveAnno : effectiveAnnos) {
            classSetMap.put(effectiveAnno, new HashSet<Field>());
        }

        //便利bean中所有field, 添加到相应set中
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            for (Class anno : effectiveAnnos) {
                Annotation annotation = field.getAnnotation(anno);
                if (annotation != null) {
                    classSetMap.get(anno).add(field);
                }
            }
        }

        //调用各自handler 校验
        for (Map.Entry<Class, Set<Field>> entry : classSetMap.entrySet()) {
            Set<Field> fieldSet = entry.getValue();

            AbstractHandler handler = handlers.get(entry.getKey());
            for (Field field : fieldSet) {
                handler.handle(bean, field, forceException, exception, isDeep);
            }
        }

    }

    //validate
    private static final <T, E extends RuntimeException> void validateNull(T bean, boolean isDeep, boolean forceException, E exception) {
        if (isDeep) {
            notNull(exception);
        }
        notNull(bean);
    }

    private static <E> void notNull(E bean) {
        if (bean == null) throw NULL_EXCEPTION;
    }
}