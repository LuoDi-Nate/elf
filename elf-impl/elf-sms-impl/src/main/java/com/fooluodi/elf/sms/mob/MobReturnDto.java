package com.fooluodi.elf.sms.mob;

/**
 * Created by di on 18/11/15.
 * mob平台返回体
 */
public class MobReturnDto {
    private int status;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MobReturnDto{");
        sb.append("status=").append(status);
        sb.append('}');
        return sb.toString();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
