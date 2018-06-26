package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.service.IOptionsService;
@Service
public class OptionsServiceImpl  implements IOptionsService{
	@Autowired
	private OptionsMapper optionsMapper;
	@Override
	public List<Options> findAll() throws Exception {
		// TODO Auto-generated method stub
		//创建空模板
		OptionsExample example = new OptionsExample();
		//调用QBE查询，并将查询结果返回
		return optionsMapper.selectByExample(example);
	}
	//通过关键字查询
	@Override
	public List<Options> query(String keywords) throws Exception {
		// TODO Auto-generated method stub
		OptionsExample example = new OptionsExample();
		example.createCriteria().andLabelLike(keywords);
		return optionsMapper.selectByExample(example);
	}
	//通过id删除
	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		optionsMapper.deleteByPrimaryKey(id);
	}
	//添加
	@Override
	public void save(Options options) throws Exception {
		// TODO Auto-generated method stub
		optionsMapper.insert(options);
	}
	//更新
	@Override
	public void update(Options options) throws Exception {
		// TODO Auto-generated method stub
		optionsMapper.updateByPrimaryKey(options);
	}
	//批量删除
	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		// TODO Auto-generated method stub
		for(long id:ids){
			optionsMapper.deleteByPrimaryKey(id);
		}
	}
}
