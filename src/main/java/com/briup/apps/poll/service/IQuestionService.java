package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.Question;

public interface IQuestionService {
	    //查询
		List<Question>findAll() throws Exception;
		//通过关键字查询
		List<Question> query(String keywords) throws Exception;
		//删除
		void deleteById(long id) throws Exception;
		//添加
		void save(Question question) throws Exception;
		//修改
		void update(Question question) throws Exception;
		//批量删除
		void batchDelete(List<Long> ids) throws Exception;
}
