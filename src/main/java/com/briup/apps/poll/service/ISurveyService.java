package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;

public interface ISurveyService {
	//查询课调信息
	List<Survey> findAll() throws Exception;
	//删除
	void deleteById(long id) throws Exception;
	
	void saveOrUpdateSurvey(Survey survey) throws Exception;
	
	List<SurveyVM> findAllSurveyVM() throws Exception;
	
	SurveyVM findAllById(long id) throws Exception;
	
	Survey findSurveyById(long id) throws Exception;
	
	List<SurveyVM> selectByStatus(String status) throws Exception;
}
