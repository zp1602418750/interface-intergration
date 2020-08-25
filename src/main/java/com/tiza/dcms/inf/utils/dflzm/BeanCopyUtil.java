package com.tiza.dcms.inf.utils.dflzm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanCopyUtil {

    private static String nameFrefix = "set";

    public static <TSource, TTarget> void BeanCopy(TSource ts,TTarget tt){
        Class<?> clazzS = ts.getClass();
        Class<?> clazzT = tt.getClass();
        // 获取源对象中所有属性的值
        Field[] fields = clazzS.getDeclaredFields();
        for (Field field:fields) {
            try {
                // 设置属性为可访问
                field.setAccessible(true);
                String name = field.getName();//获取属性的名称
                Object value = field.get(ts);//获取属性的值
                String LowName = name.toLowerCase();//将属性名字母全部小写
                Field fieldT = getField(clazzT,LowName);
                Class<?> fieldTType = fieldT.getType();
                //获取set方法名
                String setMethodName = convertStr(fieldT.getName());
                Method method = clazzT.getMethod(setMethodName,fieldTType);
                if(fieldT.isAccessible()) {
                    fieldT.setAccessible(true);
                }
                method.invoke(tt, value);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取类的属性
     * @param clazzT
     * @param name
     * @return
     */
    private static Field getField(Class<?> clazzT, String name) {
        Field[] fields = clazzT.getDeclaredFields();
        for (Field field:fields) {
            if((field.getName()).toLowerCase().equals(name)) //如果字段对应的小写字母相同
                return field;
        }
        return null;
    }

    /**
     * 将string字符串的首字母大写
     * @param str
     * @return
     */
    private static String convertStr(String str){
        String keyStr = nameFrefix.concat(str.substring(0,1).toUpperCase() + str.substring(1));
        return keyStr;
    }
}
