package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.bean.UserExample;
import com.briup.apps.poll.dao.UserMapper;
import com.briup.apps.poll.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper answersMapper;

	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		// 创建空模板
		UserExample example = new UserExample();
		// 调用QBE查询，并将查询结果返回
		return answersMapper.selectByExample(example);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		answersMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void save(User user) throws Exception {
		// TODO Auto-generated method stub
		answersMapper.insert(user);
	}

	@Override
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		answersMapper.updateByPrimaryKey(user);
	}

}