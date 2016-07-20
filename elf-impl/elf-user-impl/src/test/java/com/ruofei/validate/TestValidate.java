package com.ruofei.validate;

import com.fooluodi.elf.common.util.validate.function.ValidateHelper;

/**
 * Created by hanruofei on 16/7/20.
 */
public class TestValidate {

    public static void main(String[] args) {
        TestValidate testValidate = new TestValidate();
        RequestDto requestDto = new RequestDto();
        requestDto.setName("sssss");
        requestDto.setId(2000L);
        requestDto.setNum(10);

        long before = System.currentTimeMillis();
        for (int i=0; i<10000; i++){
            testValidate.ping(requestDto);
        }
        System.out.println(System.currentTimeMillis() - before);
    }


    public void ping(RequestDto requestDto){
        ValidateHelper.validate(requestDto);

        //System.out.println("------- "+requestDto);
    }

}
