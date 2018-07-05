package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
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
@Api(description = "年级相关接口")
public class GradeController {
	@Autowired
	private IGradeService gradeService;

	@ApiOperation(value = "级联查询所有年级信息", notes = "每个年级所属的学校")
	@GetMapping("findAllGradeVM")
	public MsgResponse findAllGradeVM() {
		try {
			List<GradeVM> list = gradeService.findAllGradeVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@ApiOperation("查询所有年级信息")
	@GetMapping("findAllGrade")
	public MsgResponse findAllGrade() {
		try {
			List<Grade> list = gradeService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	
	@ApiOperation("通过关键字查询年级信息")
	@GetMapping("findAllGradeBykeywords")
	public MsgResponse findAllGradeBykeywords(String keywords) {
		try {
			List<Grade> list = gradeService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@ApiOperation(value = "保存或更新年级信息", notes = "如果参数中包含id，说明这是一个更新操作，如果没有，这是一个保存操作")
	@PostMapping("saveOrUpdateGrade")
	public MsgResponse saveOrUpdateGrade(Grade grade) {
		try {
			if (grade != null && grade.getId() != null) {
				gradeService.update(grade);
				return MsgResponse.success("更新成功", null);
			} else {
				gradeService.save(grade);
			}
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "通过id组批量删除年级信息")
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids) {
		try {
			List<Long> idList = new ArrayList<>();
			for (long id : ids) {
				idList.add(id);
			}
			gradeService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}

	}

	@ApiOperation(value = "通过id删除年级信息")
	@GetMapping("deleteByIdCourse")
	public MsgResponse deleteByIdGrade(long id) {
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