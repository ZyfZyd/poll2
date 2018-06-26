package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireExample;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.service.IQuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService{
	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	
	//查询
	@Override
	public List<Questionnaire> findAll() throws Exception {
		// TODO Auto-generated method stub
		//创建空模板
		QuestionnaireExample example = new QuestionnaireExample();
		//调用QBE查询，并将查询结果返回
		return questionnaireMapper.selectByExampleWithBLOBs(example);
	}


	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		questionnaireMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void save(Questionnaire questionnaire) throws Exception {
		// TODO Auto-generated method stub
		questionnaireMapper.insert(questionnaire);
	}

	@Override
	public void update(Questionnaire questionnaire) throws Exception {
		// TODO Auto-generated method stub
		questionnaireMapper.updateByPrimaryKey(questionnaire);
	}

}
