package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.AnswersVM;

public interface IAnswersService {
		//查询所有答卷信息
		List<Answers> findAll() throws Exception;
		//通过id删除答卷信息
		void deleteById(long id) throws Exception;
		
		List<AnswersVM> findAllAnswersVM() throws Exception;
		//提交或者更新答卷信息
		void saveOrUpdate(Answers answers) throws Exception;
}
