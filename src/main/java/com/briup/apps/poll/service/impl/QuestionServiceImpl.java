package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;
import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionVMMapper;
import com.briup.apps.poll.service.IQuestionService;

@Service
public class QuestionServiceImpl implements IQuestionService{
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionVMMapper questionVMMapper;
	@Autowired
	private OptionsMapper optionsMapper;
	@Override
	public List<Question> findAll() throws Exception {
		// TODO Auto-generated method stub
		//创建空模板
		QuestionExample example = new QuestionExample();
		//调用QBE查询，并将查询结果返回
		return questionMapper.selectByExample(example);
		}
	//通过关键字查询
	@Override
	public List<Question> query(String keywords) throws Exception {
		// TODO Auto-generated method stub
		QuestionExample example = new QuestionExample();
		example.createCriteria().andNameLike(keywords);
		return questionMapper.selectByExample(example);
	}
	//通过id删除
	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		questionMapper.deleteByPrimaryKey(id);
	}
	//批量删除
	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		// TODO Auto-generated method stub
		for(long id:ids){
			questionMapper.deleteByPrimaryKey(id);
		}
	}
	@Override
	public List<QuestionVM> findAllQuestionVM() throws Exception {
		// TODO Auto-generated method stub
		return questionVMMapper.selectAll();
	}
	@Override
	public void saveOrUpdate(QuestionVM questionVM) throws Exception {
		// TODO Auto-generated method stub
		//从questionVM拆分出来question options
		Question question = new Question();
		question.setId(questionVM.getId());
		question.setName(questionVM.getName());
		question.setQuestiontype(questionVM.getQuestionType());
		
		List<Options> options = questionVM.getOptions();
		if(questionVM.getId()!=null){
			//修改操作 (以删代修)
			//1.修改题目信息
			questionMapper.updateByPrimaryKey(question);
			//2.题目下选项的信息
			//2.1通过question_id删除选项的信息
			OptionsExample example=new OptionsExample();
			example.createCriteria().andQuestionIdEqualTo(question.getId());
			optionsMapper.deleteByExample(example);
			//2.2新接收到的选项信息插入到数据库中
			//获取问题的主键
			long question_id=question.getId();
			//保存选项信息
			for(Options option:options){
				option.setQuestionId(question_id);
				optionsMapper.insert(option);
			}
		}else{
			//保存操作
			if(question.getQuestiontype().equals("简答题")){
				questionMapper.insert(question);
			}else{
				//1.保存问题信息
				questionMapper.insert(question);
				//获取问题的主键
				long question_id=question.getId();
				//2.保存选项信息
				for(Options option:options){
					option.setQuestionId(question_id);
					optionsMapper.insert(option);
				}
			}
			
			
		}
	}	
}
