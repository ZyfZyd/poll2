package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.extend.GradeVM;
import com.briup.apps.poll.service.IGradeService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/grade")
@Api(description="年级相关接口")
public class GradeController {
	@Autowired
	private IGradeService gradeService;
	@ApiOperation(value="查询所有年级信息",notes="每个年级包含学校")
	@GetMapping("findAllGradeVM")
	public MsgResponse findAllGradeVM(){
		try {
			List<GradeVM> list = gradeService.findAllGradeVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	//查询
	@ApiOperation("查询所有年级信息")
	@GetMapping("findAllGrade")
	public MsgResponse findAllGrade(){
		try {
			List<Grade> list=gradeService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	
	//添加
	@PostMapping("saveGrade")
	public MsgResponse saveGrade(Grade grade){
		try {
			gradeService.save(grade);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	//修改
	@PostMapping("updateGrade")
	public MsgResponse updateGrade(Grade grade){
		try {
			gradeService.update(grade);
			return MsgResponse.success("修改成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	//删除
	@GetMapping("deleteByIdCourse")
	public MsgResponse deleteByIdGrade(long id){
		try {
			gradeService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}