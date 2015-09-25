package hhj.demo.springboot.dao;

import java.util.List;
import java.util.Map;

import hhj.demo.springboot.bean.Demo;

public interface DemoDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(Demo record);

    int insertSelective(Demo record);

    Demo selectByPrimaryKey(Integer id);

    List<Demo> selectByWhereEntity(Demo record);

    int updateByPrimaryKeySelective(Demo record);

    int updateByPrimaryKey(Demo record);
    
    List<Demo> selectAll();
    
    List<Demo> selectByLength(Map<String, Object> map);
    
    
}