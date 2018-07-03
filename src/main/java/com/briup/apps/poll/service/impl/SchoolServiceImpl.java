
package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.bean.SchoolExample;
import com.briup.apps.poll.dao.SchoolMapper;
import com.briup.apps.poll.service.ISchoolService;

@Service
public class SchoolServiceImpl implements ISchoolService {
	@Autowired
	private SchoolMapper schoolMapper;

	// 查询
	@Override
	public List<School> findAll() throws Exception {
		// TODO Auto-generated method stub
		// 创建空模板
		SchoolExample example = new SchoolExample();
		// 调用QBE查询，并将查询结果返回
		return schoolMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<School> query(String keywords) throws Exception {
		// TODO Auto-generated method stub
		SchoolExample example = new SchoolExample();
		example.createCriteria().andNameLike(keywords);
		return schoolMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		// TODO Auto-generated method stub
		for (long id : ids) {
			schoolMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		schoolMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void save(School school) throws Exception {
		// TODO Auto-generated method stub
		schoolMapper.insert(school);
	}

	@Override
	public void update(School school) throws Exception {
		// TODO Auto-generated method stub
		schoolMapper.updateByPrimaryKey(school);
	}

}
