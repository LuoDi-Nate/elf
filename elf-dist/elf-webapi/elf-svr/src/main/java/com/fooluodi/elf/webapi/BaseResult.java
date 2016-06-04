package com.fooluodi.elf.webapi;

/**
 * Created by di on 29/11/15.
 */
public class BaseResult<T> {

    private boolean flag;

    private String message;

    private T content;

    public BaseResult() {

    }

    public BaseResult(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public BaseResult(boolean flag, String message, T content) {
        this.flag = flag;
        this.message = message;
        this.content = content;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

}
