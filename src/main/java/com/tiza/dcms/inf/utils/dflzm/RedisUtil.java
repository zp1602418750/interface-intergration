package com.tiza.dcms.inf.utils.dflzm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String,Object> redisTemplate;


    public  Object get(String key){
        return key==null? null:redisTemplate.opsForValue().get(key);
    }

    public  boolean set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public  boolean expire(String key,long time){
        try {
            if (time >0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public long getExpire(String key){
        return redisTemplate.getExpire(key);
    }

    public  boolean haskey(String key){
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public void del(String...key){
        if (key!=null && key.length>0){
            if (key.length==1){
                redisTemplate.delete(key[0]);
            }else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }
}
