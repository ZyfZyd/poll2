package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Course;

public interface ICourseService {
	
	List<Course> findAll() throws Exception;
	//通过关键字查询
	List<Course> query(String keywords) throws Exception;
	//删除
	void deleteById(long id) throws Exception;
	//添加
	void save(Course course) throws Exception;
	//修改
	void update(Course course) throws Exception;
	//批量删除
	void batchDelete(List<Long> ids) throws Exception;
}
