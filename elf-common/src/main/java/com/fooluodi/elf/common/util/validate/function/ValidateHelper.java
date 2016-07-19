package com.fooluodi.elf.common.util.validate.function;

import com.fooluodi.elf.common.util.validate.ValidateException.ValidateException;
import com.fooluodi.elf.common.util.validate.annotation.Max;
import com.fooluodi.elf.common.util.validate.annotation.Min;
import com.fooluodi.elf.common.util.validate.annotation.NotNull;

import java.util.*;

/**
 * Created by di on 19/7/2016.
 */
public class ValidateHelper {
    /**
     * default value
     * */
    private static final ValidateException DEFAULT_EXCEPTION = new ValidateException();
    private static final boolean DEFAULT_IS_DEEP = false;
    private static final boolean DEFAULT_FORCE_EXCEPTION = false;

    /**
     * effective annotations
     * */
    private static final Set effectiveAnnos = new HashSet(Arrays.asList(
            Max.class,
            Min.class,
            NotNull.class
    ));

    static <T, E extends Throwable> void validate(T dto) {
        validate(dto, DEFAULT_IS_DEEP);
    }

    static <T, E extends Throwable> void validate(T dto, boolean isDeep) {
        validate(dto, isDeep, DEFAULT_FORCE_EXCEPTION, DEFAULT_EXCEPTION);
    }

    /**
     * 用于校验传入dto是否满足validate条件
     *
     * @param bean 待检查的bean
     * @param isDeep 是否需要深度检查, 适用于List, Map, Set 等
     * @param forceException 是否要自定义异常
     * @param exception 传入的自定义异常
     * @param <T> Bean本身
     * @param <E> 自定义异常
     */
    static <T, E extends RuntimeException> void validate(T bean, boolean isDeep, boolean forceException, E exception) {
    }
}