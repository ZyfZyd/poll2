package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.User;

public interface IUserService {
	// 查询
	List<User> findAll() throws Exception;

	// 通过关键字查询年级信息
	List<User> query(String keywords) throws Exception;
		
	// 删除
	void deleteById(long id) throws Exception;

	// 添加
	void save(User user) throws Exception;

	// 修改
	void update(User user) throws Exception;
	//批量删除
	void batchDelete(List<Long> ids);

}
