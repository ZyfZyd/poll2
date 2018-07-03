package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Course;

public interface ICourseService {
	// 查询所有课程信息
	List<Course> findAll() throws Exception;

	// 通过关键字查询课程信息
	List<Course> query(String keywords) throws Exception;

	// 通过id删除课程信息
	void deleteById(long id) throws Exception;

	// 添加
	void save(Course course) throws Exception;

	// 修改
	void update(Course course) throws Exception;

	// 通过多个id批量删除课程信息
	void batchDelete(List<Long> ids) throws Exception;
}
