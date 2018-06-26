package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.User;


public interface IUserService {
	//查询
	List<User> findAll() throws Exception;
	//删除
	void deleteById(long id) throws Exception;
	//添加
	void save(User answers) throws Exception;
	//修改
	void update(User answers) throws Exception;
}
