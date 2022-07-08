package com.test;

import redis.clients.jedis.Jedis;

import java.util.Random;

public class VerifyCode {
    public static void main(String[] args) {
//      verify("13651236597");
        verifyPhone("44444","13651236597");
    }
    //生成6位验证码
    public static String getCode(){
        Random random=new Random();
        String code="";
        for (int i = 0; i < 6; i++) {
            int rand=random.nextInt(10);
            code +=rand;
        }
        return code;
    }
    //每个手机每天只能发送三次，验证码放入redis并设置过期时间
    public static void verify(String phone){
        Jedis jedis=new Jedis("192.168.10.12",6379);
        //拼接key
        String countKey="VerifyCode"+phone+":count";
        String codeKey="VerifyCode"+phone+":code";
        String count=jedis.get(codeKey);
        if (count==null){
            //没有发送过 为第一次发送
            jedis.setex(countKey,24*60*60,"1");
        }else if (Integer.parseInt(count)<=2){
            jedis.incr(countKey);
        }else if(Integer.parseInt(count)>2){
            System.out.println("发送次数已经达到三次");
            jedis.close();
            return;
        }
        //放入验证码
        String code1=getCode();
        jedis.setex(codeKey,120,code1);
        jedis.close();
    }
    //验证码校验
    public static void verifyPhone(String code,String phone){
        Jedis jedis=new Jedis("192.168.10.12",6379);
        String codeKey="VerifyCode"+phone+":code";
        String redisKey=jedis.get(codeKey);
        if(redisKey.equals(code)){
            System.out.println("验证码通过！");
        }else{
            System.out.println("验证码错位！");
        }
        jedis.close();
    }
}
