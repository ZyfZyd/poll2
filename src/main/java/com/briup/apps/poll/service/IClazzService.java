package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.extend.ClazzVM;

public interface IClazzService {
	// 查询班级所有信息
	List<Clazz> findAll() throws Exception;

	// 通过id删除班级信息
	void deleteById(long id) throws Exception;

	// 添加
	void save(Clazz clazz) throws Exception;

	// 修改
	void update(Clazz clazz) throws Exception;

	// 查询每个班级所属年级和班主任的信息
	List<ClazzVM> findAllClazzVM() throws Exception;

	// 批量删除班级信息
	void batchDelete(List<Long> ids) throws Exception;
}
