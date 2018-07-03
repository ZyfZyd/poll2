package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;

public interface IQuestionService {
	// 查询
	List<Question> findAll() throws Exception;

	// 通过关键字查询
	List<Question> query(String keywords) throws Exception;

	// 通过id删除问题信息
	void deleteById(long id) throws Exception;

	// 批量删除
	void batchDelete(List<Long> ids) throws Exception;

	// 查询所有的题目信息，包括选项
	List<QuestionVM> findAllQuestionVM() throws Exception;

	// 添加和保存问题信息和选项信息
	void saveOrUpdate(QuestionVM questionVM) throws Exception;
}
