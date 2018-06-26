package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Survey;

public interface ISurveyService {
	//查询
	List<Survey> findAll() throws Exception;
	//删除
	void deleteById(long id) throws Exception;
	//添加
	void save(Survey survey) throws Exception;
	//修改
	void update(Survey survey) throws Exception;
}
