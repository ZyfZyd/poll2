package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Clazz;

public interface IClazzService {
	//查询
	List<Clazz> findAll() throws Exception;
	//删除
    void deleteById(long id) throws Exception;
    //添加
    void save(Clazz clazz) throws Exception;
    //修改
    void update(Clazz clazz) throws Exception;
}
