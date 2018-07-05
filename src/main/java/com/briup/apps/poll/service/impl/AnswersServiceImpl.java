package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.AnswersExample;
import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.dao.AnswersMapper;
import com.briup.apps.poll.dao.extend.AnswersVMMapper;
import com.briup.apps.poll.service.IAnswersService;

@Service
public class AnswersServiceImpl implements IAnswersService {
	@Autowired
	private AnswersMapper answersMapper;
	@Autowired
	private AnswersVMMapper answersVMMapper;

	@Override
	public List<Answers> findAll() throws Exception {
		// TODO Auto-generated method stub
		// 创建空模板
		AnswersExample example = new AnswersExample();
		// 调用QBE查询，并将查询结果返回
		return answersMapper.selectByExample(example);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		answersMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<AnswersVM> findAllAnswersVM() throws Exception {
		// TODO Auto-generated method stub
		return answersVMMapper.selectAll();
	}

	@Override
	public void saveOrUpdate(Answers answers) throws Exception {
		// TODO Auto-generated method stub
		if (answers.getId() != null) {
			answersMapper.updateByPrimaryKey(answers);
		} else {
			answersMapper.insert(answers);
		}
	}

	@Override
	public List<Answers> findAnswersBySurverId(long surveyId) throws Exception {
		// TODO Auto-generated method stub
		AnswersExample example = new AnswersExample();
		example.createCriteria().andSurveyIdEqualTo(surveyId);
		return answersMapper.selectByExample(example);
	}
}
