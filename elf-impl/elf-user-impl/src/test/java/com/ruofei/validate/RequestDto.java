package com.ruofei.validate;

import com.fooluodi.elf.common.util.validate.annotation.Max;
import com.fooluodi.elf.common.util.validate.annotation.NotNull;

/**
 * Created by hanruofei on 16/7/20.
 */
public class RequestDto {

    String name;

    Long id;

    @Max(50)
    int num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", num=" + num +
                '}';
    }
}
