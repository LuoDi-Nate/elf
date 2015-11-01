package com.fooluodi.elf.annotations.checkpermission;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by di on 8/9/15.
 *
 * @see CheckPermission 注解的拦截器
 * 用来判断 使用标注有此注解的方法的用户 是否有调用该方法的权限
 */
public class CheckPermissionInterceptor implements MethodInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(CheckPermissionInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
//        // 判断是否有CheckPermission注解 没有放过
//        Method method = invocation.getMethod();
//        CheckPermission checkSignature = method.getAnnotation(CheckPermission.class);
//        if (checkSignature == null) {
//            return invocation.proceed();
//        }
//
//        Object[] arguments = invocation.getArguments();
//        if (arguments.length == 0) {
//            throw new MinosCheckPermissionServiceException(MinosCheckPermissionExceptionCode.ERROR_PARAMEATERS);
//        }
//        //获取currentuser
//        MinosUser currentUser = getUser(arguments);
//
//        //获取annotation的值
//        String[] permissions = checkSignature.permission();
//        if (permissions.length == 0) {
//            throw new MinosCheckPermissionServiceException(MinosCheckPermissionExceptionCode.ERROR_PARAMEATERS);
//        }
//        List<String> queryList = new ArrayList<>();
//        for (String str : permissions) {
//            queryList.add(str);
//        }
//        AskPermissionListDto permissionAsk = new AskPermissionListDto();
//        permissionAsk.setAskPermissionList(queryList);
//        permissionAsk.setUserId(currentUser.getId());
//
//        //校验该用户是否所有注解中所有权限
//        Map<String, Integer> checkPermissionMap = permissionService.checkPermission(permissionAsk);
//        boolean flag = true;
//        for (String str : checkPermissionMap.keySet()) {
//            if (!Objects.equals(1, checkPermissionMap.get(str))) {
//                flag = false;
//            }
//        }
//
//        if (flag) {
//            try {
//                return invocation.proceed();
//            } catch (Exception e) {
//                //抛出原有的exception
//                if (e instanceof InvocationTargetException) {
//                    InvocationTargetException originException = (InvocationTargetException) e;
//                    throw originException.getTargetException();
//                }
//                throw e;
//            }
//        } else {
//            logger.warn("someone get around front page , get here user:{}", currentUser);
//            throw new MinosCheckPermissionServiceException(MinosCheckPermissionExceptionCode.ERROR_PERMISSION_VALID);
//        }
        return null;
    }

//    private MinosUser getUser(Object[] arguments) throws MinosCheckPermissionServiceException {
//        MinosUser currentUser = null;
//        for (Object o : arguments) {
//            if (o != null && o instanceof MinosUser) {
//                currentUser = (MinosUser) o;
//                break;
//            }
//        }
//        if (currentUser == null) {
//            throw new MinosCheckPermissionServiceException(MinosCheckPermissionExceptionCode.ERROR_PARAMEATERS);
//        }
//        return currentUser;
//    }
}
