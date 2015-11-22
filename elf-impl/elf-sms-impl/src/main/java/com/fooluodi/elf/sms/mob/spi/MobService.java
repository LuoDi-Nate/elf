package com.fooluodi.elf.sms.mob.spi;


import com.fooluodi.elf.sms.mob.utils.MobClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 测试
 * @author Administrator
 */
@Component
public class MobService {

	public static void main(String[] args) throws Exception {

		String appkey = "c0926b9c0c3a";
		String phone = "18503517993";
		String zone = "86";
		String code = "1111";

		List<String> paramList = new ArrayList<>();
		paramList.add("appkey="+appkey);
		paramList.add("phone="+phone);
		paramList.add("zone="+zone);
		paramList.add("code="+code);

		String result = status(paramList, "https://web.sms.mob.com/sms/verify");

		System.out.println(result);

	}

	public String mobSmsCheck(String appkey, String phone, String zone, String code, String address) throws Exception {
		List<String> paramList = new ArrayList<>();
		paramList.add("appkey="+appkey);
		paramList.add("phone="+phone);
		paramList.add("zone="+zone);
		paramList.add("code="+code);

		return status(paramList, address);
	}

	/**
	 * 服务端运行状态
	 * @return
	 * @throws Exception
	 */
	public static String status(List<String> param, String address) throws Exception{

		MobClient client = null;
		try {
			client = new MobClient(address);
			client.setParams(param);
			client.addRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			client.addRequestProperty("Accept", "application/json");
			String result = client.post();
			return result;
		} finally {
			client.release();
		}
	}
	
	
}
