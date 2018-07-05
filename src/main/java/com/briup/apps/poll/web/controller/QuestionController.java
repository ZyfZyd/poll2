package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.service.IQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/question")
@Api(description = "问题相关接口")
public class QuestionController {
	@Autowired
	private IQuestionService questionService;

	@ApiOperation(value = "查询单表下所有的题目信息")
	@GetMapping("findAllQuestion")
	public MsgResponse findAllQuestion() {
		try {
			List<Question> list = questionService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "批量删除题目信息", notes = "删除题目信息以及该题目下所有的选项信息")
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids) {
		try {
			List<Long> idList = new ArrayList<>();
			for (long id : ids) {
				idList.add(id);
			}
			questionService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	
	@ApiOperation("通过关键字查询问题信息")
	@GetMapping("findAllQuestionBykeywords")
	public MsgResponse findAllQuestionBykeywords(String keywords) {
		try {
			List<Question> list = questionService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value = "删除题目信息", notes = "删除题目的信息以及该题目下所有的选项信息")
	@GetMapping("deleteByIdQuestion")
	public MsgResponse deleteByIdQuestion(long id) {
		try {
			questionService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findAllQuestionVM")
	@ApiOperation(value = "查询所有的题目信息", notes = "每个题目信息包含该题目下所有的选项信息")
	public MsgResponse findAllQuestionVM() {
		try {
			List<QuestionVM> list = questionService.findAllQuestionVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@PostMapping("saveOrUpdateQuestion")
	@ApiOperation(value = "保存或修改题目信息", notes = "如果题目id不为空表示更新操作，如果题目id为空表示插入操作，保存或者更新题目的时候级联保存或者更新选项")
	public MsgResponse saveOrUpdateQuestion(QuestionVM question) {
		try {
			// 调用Service层代码完成保存和更新操作
			questionService.saveOrUpdate(question);
			return MsgResponse.success("success", question);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
