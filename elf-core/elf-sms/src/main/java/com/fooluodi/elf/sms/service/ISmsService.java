package com.fooluodi.elf.sms.service;

/**
 * Created by di on 18/11/15.
 * 关于短信的服务
 * 具体实现见impl, 降低耦合, 即便切换底层短信平台, 接口不会修改
 */
public interface ISmsService {
    /**
     * 输入手机号和一个验证码, 查看是否通过验证
     *
     * @param phoneNum 目标手机号
     * @param code 目标输入的验证码
     *
     * @return 是否合法
     * */
    public boolean checkLegality(String phoneNum, String code);
}
