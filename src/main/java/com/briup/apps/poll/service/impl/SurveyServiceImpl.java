package com.briup.apps.poll.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.SurveyExample;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.dao.SurveyMapper;
import com.briup.apps.poll.dao.extend.SurveyVMMapper;
import com.briup.apps.poll.service.ISurveyService;


@Service
public class SurveyServiceImpl implements ISurveyService{
	@Autowired
	private SurveyMapper surveyMapper;
	@Autowired
	private SurveyVMMapper surveyVMMapper;
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
	public List<SurveyVM> findAllSurveyVM() throws Exception {
		// TODO Auto-generated method stub
		return surveyVMMapper.selectAll();
	}

	@Override
	public void saveOrUpdateSurvey(Survey survey) throws Exception {
		// TODO Auto-generated method stub
		//判断是保存还是更新
		if(survey.getId()!=null){
			//更新
			surveyMapper.updateByPrimaryKey(survey);
		}else{
			//在保存课调之前先初始化课调信息
		survey.setStatus(Survey.STATUS_INIT);
		survey.setCode("");
		
		Date surveyDate=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str=sdf.format(surveyDate);
		survey.setSurveydate(str);
		
		surveyMapper.insert(survey);
		}
	}

	@Override
	public SurveyVM findAllById(long id) throws Exception {
		// TODO Auto-generated method stub
		return surveyVMMapper.selectById(id);
	}

	@Override
	public Survey findSurveyById(long id) throws Exception {
		// TODO Auto-generated method stub
		return surveyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SurveyVM> selectByStatus(String status) throws Exception {
		// TODO Auto-generated method stub
		return surveyVMMapper.selectByStatus(status);
	}

}
