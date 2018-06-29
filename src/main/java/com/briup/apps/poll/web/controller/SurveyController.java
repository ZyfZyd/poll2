package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/survey")
@Api(description="课调相关接口")
public class SurveyController {
	@Autowired
	private ISurveyService surveyService;
	
	@ApiOperation(value="查询课调信息")
	@GetMapping("findAllSurvey")
	public MsgResponse findAllSurvey(){
		try {
			List<Survey> list=surveyService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	@ApiOperation(value="保存或更新",notes="只需要输入courseId,clazzId,userId,questionnairsId")
	@PostMapping("saveOrUpdateSurvey")
	public MsgResponse saveOrUpdateSurvey(Survey survey){
		try {
			surveyService.saveOrUpdateSurvey(survey);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	@ApiOperation(value="通过id删除课调信息")
	@GetMapping("deleteByIdSurvey")
	public MsgResponse deleteByIdSurvey(long id){
		try {
			surveyService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findAllSurveyVM")
	@ApiOperation(value="查询所有的课调信息",notes="级联查询课调关联的课程、班级、讲师、问卷")
	public MsgResponse findAllSurveyVM(){
		try{
			List<SurveyVM> list=surveyService.findAllSurveyVM();
			return MsgResponse.success("success",list);
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findAllSurveyById")
	@ApiOperation(value="查询所有的课调信息",notes="级联查询课调关联的课程、班级、讲师、问卷")
	public MsgResponse findAllSurveyById(long id){
		try{
			List<SurveyVM> list=surveyService.findAllSurveyVM();
			return MsgResponse.success("success",list);
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
