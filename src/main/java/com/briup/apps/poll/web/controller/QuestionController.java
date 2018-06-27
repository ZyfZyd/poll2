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
@Api(description="问题相关接口")
public class QuestionController {
	@Autowired
	private IQuestionService questionService;
	    //查询
		@GetMapping("findAllQuestion")
		public MsgResponse findAllQuestion(){
			try {
				List<Question> list=questionService.findAll();
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
				questionService.batchDelete(idList);
				return MsgResponse.success("批量删除成功", null);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return MsgResponse.error(e.getMessage());
				}

			}
			//添加
			@PostMapping("saveQuestion")
			public MsgResponse saveQuestion(Question question){
				try {
					questionService.save(question);
					return MsgResponse.success("保存成功", null);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return MsgResponse.error(e.getMessage());
				}
				
			}
			//修改
			@PostMapping("updateQuestion")
			public MsgResponse updateCourse(Question question){
				try {
					questionService.update(question);
					return MsgResponse.success("修改成功", null);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return MsgResponse.error(e.getMessage());
				}
			}
			//删除
			@GetMapping("deleteByIdQuestion")
			public MsgResponse deleteByIdQuestion(long id){
				try {
					questionService.deleteById(id);
					return MsgResponse.success("删除成功", null);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return MsgResponse.error(e.getMessage());
				}
			}
			//查询
			@GetMapping("findAllQuestionVM")
			@ApiOperation(value="查询所有的题目信息",notes="每个题目信息包含该题目下所有的选项信息")
			public MsgResponse findAllQuestionVM(){
				try {
					List<QuestionVM> list=questionService.findAllQuestionVM();
					return MsgResponse.success("success", list);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return MsgResponse.error(e.getMessage());
				  }
				}
		}
			
