package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.School;

public interface ISchoolService {
	// 查询所有学校信息
	List<School> findAll() throws Exception;

	// 通过关键字查询
	List<School> query(String keywords) throws Exception;

	// 通过id删除学校信息
	void deleteById(long id) throws Exception;

	// 添加
	void save(School school) throws Exception;

	// 修改
	void update(School school) throws Exception;

	// 批量删除
	void batchDelete(List<Long> ids) throws Exception;
}