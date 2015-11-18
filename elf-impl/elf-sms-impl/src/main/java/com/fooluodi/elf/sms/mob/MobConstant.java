package com.fooluodi.elf.sms.mob;

/**
 * Created by di on 18/11/15.
 * mob返回的可能结果
 *
 * @url  http://wiki.mob.com/smssdk-web-1-3-0verify/
 */
public class MobConstant {
    //成功
    public static final int MOB_SUCCESS = 200;

    //AppKey为空
    public static final int MOB_HAS_NO_APPKEY = 405;

    //AppKey无效
    public static final int MOB_INVALID_APPKEY = 406;

    //国家代码或手机号码为空
    public static final int MOB_NO_ZONE = 456;

    //手机号码格式错误
    public static final int MOB_INVALID_PHONE_NUMBER = 457;

    //请求校验的验证码为空
    public static final int MOB_NO_CODE = 466;

    //请求校验验证码频繁（5分钟内同一个appkey的同一个号码最多只能校验三次)
    public static final int MOB_TOO_MANY_TIMES = 467;

    //验证码错误
    public static final int MOB_WRONG_CODE = 468;

    //没有打开服务端验证开关
    public static final int MOB_NOT_ACCESS_OPTION = 474;

}
