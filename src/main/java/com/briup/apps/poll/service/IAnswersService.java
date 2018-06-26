package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Answers;

public interface IAnswersService {
		//查询
		List<Answers> findAll() throws Exception;
		//删除
		void deleteById(long id) throws Exception;
		//添加
		void save(Answers answers) throws Exception;
		//修改
		void update(Answers answers) throws Exception;
}
