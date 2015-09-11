package me.ele.minos.annotations.checkpermission;


import java.lang.annotation.*;

/**
 *
 * Created by di on 8/9/15.
 * 注解用于controller方法上
 * 标识那些需要校验登陆者是否拥有该注解声明的code的权限
 * eg : @CheckPermisssion(permission = {"Minos-Auth-Permission", "Minos-Edit-Rate-Permission"})
 *
 * @warn 使用这个注解需要保证method中包含MinosUser参数
 * 权限code参数 @see me.ele.minos.coffee.constant.MinosConstant
 * @throw MinosCheckPermissionServiceException
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckPermission {
    public String[] permission() default {""};
}
