package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Grade;

public interface IGradeService {
	//查询
	List<Grade> findAll() throws Exception;
	//通过关键字查询
	List<Grade> query(String keywords) throws Exception;
	//删除
	void deleteById(long id) throws Exception;
	//添加
	void save(Grade grade) throws Exception;
	//修改
	void update(Grade grade) throws Exception;

}


