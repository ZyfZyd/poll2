package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.GradeExample;
import com.briup.apps.poll.bean.extend.GradeVM;
import com.briup.apps.poll.dao.GradeMapper;
import com.briup.apps.poll.dao.extend.GradeVMMapper;
import com.briup.apps.poll.service.IGradeService;

@Service
public class GradeServiceImpl implements IGradeService {
	@Autowired
	private GradeMapper gradeMapper;
	@Autowired
	private GradeVMMapper gradeVMMapper;

	// 查询
	@Override
	public List<Grade> findAll() throws Exception {
		// TODO Auto-generated method stub
		// 创建空模板
		GradeExample example = new GradeExample();
		// 调用QBE查询，并将查询结果返回
		return gradeMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<Grade> query(String keywords) throws Exception {
		// TODO Auto-generated method stub
		GradeExample example = new GradeExample();
		example.createCriteria().andNameLike("%"+keywords+"%");
		return gradeMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		gradeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void save(Grade grade) throws Exception {
		// TODO Auto-generated method stub
		gradeMapper.insert(grade);
	}

	@Override
	public void update(Grade grade) throws Exception {
		// TODO Auto-generated method stub
		gradeMapper.updateByPrimaryKey(grade);
	}

	@Override
	public List<GradeVM> findAllGradeVM() throws Exception {
		// TODO Auto-generated method stub
		return gradeVMMapper.selectAll();
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		for (long id : ids) {
			gradeMapper.deleteByPrimaryKey(id);

		}
	}
}
