package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.service.IOptionsService;
import com.briup.apps.poll.service.IQuestionService;
import com.briup.apps.poll.util.MsgResponse;
	@RestController
	@RequestMapping("/options")
    public class OptionsController {
	
		@Autowired
		private IOptionsService optionsService;
		    //查询
			@GetMapping("findAllOptions")
			public MsgResponse findAllQuestion(){
				try {
					List<Options> list=optionsService.findAll();
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
					optionsService.batchDelete(idList);
					return MsgResponse.success("批量删除成功", null);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return MsgResponse.error(e.getMessage());
					}

				}
				//添加
				@PostMapping("saveOptions")
				public MsgResponse saveOptions(Options options){
					try {
						optionsService.save(options);
						return MsgResponse.success("保存成功", null);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return MsgResponse.error(e.getMessage());
					}
					
				}
				//修改
				@PostMapping("updateOptions")
				public MsgResponse updateCourse(Options options){
					try {
						optionsService.update(options);
						return MsgResponse.success("修改成功", null);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return MsgResponse.error(e.getMessage());
					}
				}
				//删除
				@GetMapping("deleteByIdoptions")
				public MsgResponse deleteByIdOptions(long id){
					try {
						optionsService.deleteById(id);
						return MsgResponse.success("删除成功", null);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return MsgResponse.error(e.getMessage());
					}
				}
			}
				
