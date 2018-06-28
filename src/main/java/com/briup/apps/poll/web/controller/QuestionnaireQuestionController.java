package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.service.IQuestionnaireQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/questionnairequestion")
@Api(description="问卷问题桥相关接口")
public class QuestionnaireQuestionController {
	@Autowired
	private IQuestionnaireQuestionService questionnairequestionService;
	//查询
	@GetMapping("findAllQuestionnaireQuestion")
	public MsgResponse findAllQuestionnaireQuestion(){
		try {
			List<QuestionnaireQuestion> list=questionnairequestionService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	//添加
	@PostMapping("saveQuestionnaireQuestion")
	public MsgResponse saveQuestionnaireQuestion(QuestionnaireQuestion questionnairequestion){
		try {
			questionnairequestionService.save(questionnairequestion);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	//修改
	@PostMapping("updateQuestionnaireQuestion")
	public MsgResponse updateQuestionnaireQuestion(QuestionnaireQuestion questionnairequestion){
		try {
			questionnairequestionService.update(questionnairequestion);
			return MsgResponse.success("修改成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	//删除
	@GetMapping("deleteByIdQuestionnaireQuestion")
	public MsgResponse deleteByIdQuestionnaireQuestion(long id){
		try {
			questionnairequestionService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
