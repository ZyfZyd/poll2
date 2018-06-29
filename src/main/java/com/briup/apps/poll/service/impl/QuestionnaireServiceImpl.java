package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireExample;
import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.QuestionnaireQuestionExample;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.dao.QuestionnaireQuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionnaireVMMapper;
import com.briup.apps.poll.service.IQuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService{
	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	@Autowired
	private  QuestionnaireVMMapper questionnaireVMMapper;
	@Autowired
	private QuestionnaireQuestionMapper  qqMapper;
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
	public QuestionnaireVM findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return questionnaireVMMapper.selectById(id);
	}


	@Override
	public void saveOrUpdate(Questionnaire questionnaire, long[] ids) throws Exception {
		// TODO Auto-generated method stub
		//判断是保存还是更新
		//如果是保存
		if(questionnaire.getId()==null){
			//保存问卷信息
			questionnaireMapper.insert(questionnaire);
			//维护问卷和问题的关系
			for(long id:ids){
				QuestionnaireQuestion qq=new QuestionnaireQuestion();
				qq.setQuestionId(id);
				qq.setQuestionnaireId(questionnaire.getId());
				qqMapper.insert(qq);
			}
		}else{
			//修改
			
			//删除问卷下所有问题的关系
			QuestionnaireQuestionExample qqExample=new QuestionnaireQuestionExample();
			qqExample.createCriteria().andQuestionnaireIdEqualTo(questionnaire.getId());
			qqMapper.deleteByExample(qqExample);
			//重新维护问卷和问题的关系
			for(long id:ids){
				QuestionnaireQuestion qq=new QuestionnaireQuestion();
				qq.setQuestionId(id);
				qq.setQuestionnaireId(questionnaire.getId());
				qqMapper.insert(qq);
			}
			//更新问卷信息
			questionnaireMapper.updateByPrimaryKey(questionnaire);
		}
	}

}
