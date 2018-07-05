package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/answers")
@Api(description = "学生答卷相关接口")
public class AnswersController {
	@Autowired
	private IAnswersService answersService;

	@ApiOperation(value = "查询答卷信息")
	@GetMapping("findAllAnswers")
	public MsgResponse findAllAnswers() {
		try {
			List<Answers> list = answersService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@PostMapping("submitAnswer")
	@ApiOperation(value = "提交答卷，每个学生提交一份")
	public MsgResponse submitAnswer(Answers answers) {
		try {
			// 判断用户是否具有答卷权限（是否提交过）

			// 保存答卷信息
			answersService.saveOrUpdate(answers);
			return MsgResponse.success("提交成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	
	
	@ApiOperation(value = "通过id删除答卷信息")
	@GetMapping("deleteByIdAnswers")
	public MsgResponse deleteByIdAnswers(long id) {
		try {
			answersService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findAllAnswersVM")
	@ApiOperation(value = "查询所有的答卷信息", notes = "")
	public MsgResponse findAllAnswersVM() {
		try {
			List<AnswersVM> list = answersService.findAllAnswersVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
