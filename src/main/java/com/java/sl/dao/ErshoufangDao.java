package com.java.sl.dao;

import com.java.sl.bean.Ershoufang;
import java.lang.reflect.Field;

import java.util.*;

/**
 * Author: zhangliujie
 * Time: 2018/9/30
 * Email: liujiezhangbupt@gmail.com
 * Description:
 */
public class ErshoufangDao {
    private SqlDB sqlDB = new SqlDB();

    public void add(Ershoufang ershoufang, String table){
        Map<String, String> itemVals = getObjAttr(ershoufang);
        // 生成sql的key和value
        List<String> keys = new LinkedList<String>();
        List<String> vals = new LinkedList<String>();
        for(Map.Entry<String, String> entry : itemVals.entrySet()){
            keys.add(entry.getKey());
            vals.add("'" + entry.getValue() + "'");
        }
        String key = String.join(",", keys);
        String val = String.join(",", vals);

        String sql = "INSERT INTO "+ table +" ( " + key +" ) VALUES ( " + val + " );";
        System.out.println(sql);
        try{
            sqlDB.dqlExecute(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 获取类的所有成员变量和值,包括父类，但是不包括Object
    protected Map getObjAttr(Ershoufang ershoufang){
        Map keyVals = new HashMap();

        List<Field> fieldList = new ArrayList<Field>();
        Class tmpClass = Ershoufang.class;
        while (tmpClass !=null && !tmpClass.getName().equalsIgnoreCase("java.lang.object") )
        {
            fieldList.addAll(Arrays.asList(tmpClass .getDeclaredFields()));
            tmpClass = tmpClass.getSuperclass(); //得到父类,然后赋给自己
        }

        for(Field field : fieldList){
            String varName = field.getName();
            try{
                boolean access = field.isAccessible();
                if(!access) field.setAccessible(true);

                Object o = field.get(ershoufang);
                if(!varName.equals( "baseInfo") && !varName.equals("tradInfo")){
                    keyVals.put(varName, o);
                }

                if(access) field.setAccessible(false);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return keyVals;

    }
}
