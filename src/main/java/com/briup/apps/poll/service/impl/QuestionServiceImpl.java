package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
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
	//添加
	@Override
	public void save(Question question) throws Exception {
		// TODO Auto-generated method stub
		questionMapper.insert(question);
	}
	//更新
	@Override
	public void update(Question question) throws Exception {
		// TODO Auto-generated method stub
		questionMapper.updateByPrimaryKey(question);
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
			//修改操作 (问题 修改， 选项：先删除后添加)
			
		}else{
			//保存操作
			//1.保存问题信息
			questionMapper.insert(question);
			long question_id=question.getId();
			//2.保存选项信息
			for(Options option:options){
				option.setQuestionId(question_id);
				optionsMapper.insert(option);
			}
		}
	}	
}
