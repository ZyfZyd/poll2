package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.service.IQuestionnaireService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/questionnaire")
@Api(description="问卷相关接口")
public class QuestionnaireController {
	@Autowired
	private IQuestionnaireService questionnaireService;
	//查询
	@ApiOperation(value="查询所有问卷")
	@GetMapping("findAllQuestionnaire")
	public MsgResponse findAllQuestionnaire(){
		try {
			List<Questionnaire> list=questionnaireService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	@ApiOperation(value="通过问卷id查询问卷",notes="")
	@GetMapping("findAllQuestionnaireVMById")
	public MsgResponse findAllQuestionnaireVMById(long id){
		try {
		QuestionnaireVM list = questionnaireService.findById(id);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
		
	@ApiOperation(value="通过问卷id删除问卷",notes="级联删除问卷和问题的关系")
	@GetMapping("deleteByIdQuestionnaire")
	public MsgResponse deleteByIdQuestionnaire(long id){
		try {
			questionnaireService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存和修改问卷信息",notes="级联删除问卷和问题的关系")
	@PostMapping("saveOrUpdateQuestionnaire")
	public MsgResponse saveOrUpdateQuestionnaire(Questionnaire questionnaire,long[] questionIds){
		try {
			questionnaireService.saveOrUpdate(questionnaire,questionIds);
			return MsgResponse.success("保存或更新成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
