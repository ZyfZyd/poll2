package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.extend.QuestionnaireQuestionVM;

public interface IQuestionnaireQuestionService {
	//查询
	List<QuestionnaireQuestion> findAll() throws Exception;
	
	List<QuestionnaireQuestionVM> findAllQuestionnaireQuestionVM() throws Exception;
	//删除
	void deleteById(long id) throws Exception;
	//添加
	void save(QuestionnaireQuestion questionnairequestion) throws Exception;
	//修改
	void update(QuestionnaireQuestion questionnairequestion) throws Exception;
	
}
