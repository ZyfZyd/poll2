package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.QuestionnaireQuestionExample;
import com.briup.apps.poll.bean.extend.QuestionnaireQuestionVM;
import com.briup.apps.poll.dao.QuestionnaireQuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionnaireQuestionVMMapper;
import com.briup.apps.poll.service.IQuestionnaireQuestionService;

@Service
public class QuestionnaireQuestionServiceImpl implements IQuestionnaireQuestionService{
	@Autowired
	private QuestionnaireQuestionMapper questionnairequestionMapper;
	@Autowired
	private QuestionnaireQuestionVMMapper questionnairequestionVMMapper;
	//查询
	@Override
	public List<QuestionnaireQuestion> findAll() throws Exception {
		// TODO Auto-generated method stub
		//创建空模板
		QuestionnaireQuestionExample example = new QuestionnaireQuestionExample();
		//调用QBE查询，并将查询结果返回
		return questionnairequestionMapper.selectByExample(example);
	}


	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		questionnairequestionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void save(QuestionnaireQuestion questionnairequestion) throws Exception {
		// TODO Auto-generated method stub
		questionnairequestionMapper.insert(questionnairequestion);
	}

	@Override
	public void update(QuestionnaireQuestion questionnairequestion) throws Exception {
		// TODO Auto-generated method stub
		questionnairequestionMapper.updateByPrimaryKey(questionnairequestion);
	}
	@Override
	public List<QuestionnaireQuestionVM> findAllQuestionnaireQuestionVM() throws Exception {
		// TODO Auto-generated method stub
		return questionnairequestionVMMapper.selectAll();
	}

}
