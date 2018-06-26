package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Questionnaire;

public interface IQuestionnaireService {
	//查询
	List<Questionnaire> findAll() throws Exception;
	
	//删除
	void deleteById(long id) throws Exception;
	//添加
	void save(Questionnaire questionnaire) throws Exception;
	//修改
	void update(Questionnaire questionnaire) throws Exception;
	
}
