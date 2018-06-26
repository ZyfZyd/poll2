package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.SurveyExample;
import com.briup.apps.poll.dao.SurveyMapper;
import com.briup.apps.poll.service.ISurveyService;

@Service
public class SurveyServiceImpl implements ISurveyService{
	@Autowired
	private SurveyMapper surveyMapper;
	@Override
	public List<Survey> findAll() throws Exception {
		// TODO Auto-generated method stub
		//创建空模板
		SurveyExample example = new SurveyExample();
		//调用QBE查询，并将查询结果返回
		return surveyMapper.selectByExample(example);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		surveyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void save(Survey survey) throws Exception {
		// TODO Auto-generated method stub
		surveyMapper.insert(survey);
	}

	@Override
	public void update(Survey survey) throws Exception {
		// TODO Auto-generated method stub
		surveyMapper.updateByPrimaryKey(survey);
	}

}
