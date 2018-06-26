package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.ClazzExample;
import com.briup.apps.poll.dao.ClazzMapper;
import com.briup.apps.poll.service.IClazzService;

@Service
public class ClazzServiceImpl implements IClazzService{
	@Autowired
	private ClazzMapper answersMapper;
	
	@Override
	public List<Clazz> findAll() throws Exception {
		// TODO Auto-generated method stub
		//创建空模板
		ClazzExample example = new ClazzExample();
		//调用QBE查询，并将查询结果返回
		return answersMapper.selectByExample(example);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		answersMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void save(Clazz clazz) throws Exception {
		// TODO Auto-generated method stub
		answersMapper.insert(clazz);
	}

	@Override
	public void update(Clazz clazz) throws Exception {
		// TODO Auto-generated method stub
		answersMapper.updateByPrimaryKey(clazz);
	}

}