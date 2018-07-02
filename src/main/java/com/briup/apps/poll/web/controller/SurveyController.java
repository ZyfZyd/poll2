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
	
	@GetMapping("startSurvey")
	@ApiOperation(value="开启课调")
	public MsgResponse startSurvey(long id){
		try {
			//通过ID查询出课调信息
			Survey survey=surveyService.findSurveyById(id);
			//判断当前课调状态为未开启状态才能开启一个课调
			if(survey.getStatus().equals(Survey.STATUS_INIT)){
				//修改这个课调对象
			survey.setStatus(Survey.STATUS_BEGIN);
			String code=survey.getId().toString();
			survey.setCode(code);
			surveyService.saveOrUpdateSurvey(survey);
			return MsgResponse.success("开启成功", null);
			//操作Session
			}else{
				return MsgResponse.error("状态不合法+"+survey.getStatus());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("stopSurvey")
	@ApiOperation(value="结束课调")
	public MsgResponse stopSurvey(long id){
			try {
				//通过ID查询出课调信息
				Survey survey=surveyService.findSurveyById(id);
				//修改这个课调对象
				survey.setStatus(Survey.STATUS_NO_CHECK);
				surveyService.saveOrUpdateSurvey(survey);
				return MsgResponse.success("成功关闭", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findSurveyVMByStatus")
	@ApiOperation(value="通过状态查询课调")
	public MsgResponse findSurveyVMByStatus(String status){
			try {
				List<SurveyVM> list= surveyService.selectByStatus(status);
				return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@GetMapping("checkSurvey")
	@ApiOperation(value="审核课调",notes="id表示课调编号，status表示审核状态，0/审核不通过，1/审核通过")
	public MsgResponse checkSurvey(long id,int status){
			try {
				//通过ID查询出课调信息
				Survey survey=surveyService.findSurveyById(id);
				String message="";
				//如果当前课调属于未审核状态，才可以对其进行审核
				if(survey.getStatus().equals(Survey.STATUS_NO_CHECK)){
					if(status==0){
					message="审核不通过";
					survey.setStatus(Survey.STATUS_NO_PASS);
				}else{
					message="审核通过";
					survey.setStatus(Survey.STATUS_CHECK_PASS);
					
				}
				}else{
					message="课调状态不合法";
				}
				surveyService.saveOrUpdateSurvey(survey);
				return MsgResponse.success(message, null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("loginSurvey")
	@ApiOperation(value="登录课调",notes="code表示课调编码")
	public MsgResponse loginSurvey(long code){
			try {
				//通过id查询课调信息
				SurveyVM surveyVM=surveyService.findAllById(code);
				//判断课调是否还在进行
				if(surveyVM.getStatus().equals(Survey.STATUS_BEGIN)){
					//判断用户是否完成答卷操作（暂时不做）
					
					return MsgResponse.success("success", surveyVM);
				}else{
					return MsgResponse.error("课调状态不合法："+surveyVM.getStatus());
				}
				
//				List<SurveyVM> list=surveyService.findAllSurveyVM();
				
//				return MsgResponse.success("success",surveyVM);
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
}
