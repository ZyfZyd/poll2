package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.service.ISchoolService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/school")
@Api(description="学校相关接口")
public class SchoolController {
	@Autowired
	private ISchoolService schoolService;
	//查询
	@GetMapping("findAllSchool")
	public MsgResponse findAllSchool(){
		try {
			List<School> list=schoolService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	//批量删除
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids){
		try {
			List<Long> idList=new ArrayList<>();
		for(long id:ids){
			idList.add(id);
		}
		schoolService.batchDelete(idList);
		return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	//添加
	@PostMapping("saveSchool")
	public MsgResponse saveSchool(School school){
		try {
			schoolService.save(school);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	//修改
	@PostMapping("updateSchool")
	public MsgResponse updateSchool(School school){
		try {
			schoolService.update(school);
			return MsgResponse.success("修改成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	//删除
	@GetMapping("deleteByIdSchool")
	public MsgResponse deleteByIdCourse(long id){
		try {
			schoolService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}