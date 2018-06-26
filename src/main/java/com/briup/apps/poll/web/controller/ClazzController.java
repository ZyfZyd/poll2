package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.service.IClazzService;
import com.briup.apps.poll.util.MsgResponse;

@RestController
@RequestMapping("/clazz")
public class ClazzController {
	@Autowired
	private IClazzService clazzService;
    //查询
	@GetMapping("findAllClazz")
	public MsgResponse findAllClazz(){
		try{
			List<Clazz> list=clazzService.findAll();
			return MsgResponse.success("success",list);
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

//添加
	@PostMapping("saveClazz")
	public MsgResponse saveClazz(Clazz clazz){
		try {
			clazzService.save(clazz);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	//修改
		@PostMapping("updateClazz")
		public MsgResponse updateClazz(Clazz clazz){
			try {
				clazzService.update(clazz);
				return MsgResponse.success("修改成功", null);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		//删除
		@GetMapping("deleteByIdClazz")
		public MsgResponse deleteByIdClazz(long id){
			try {
				clazzService.deleteById(id);
				return MsgResponse.success("删除成功", null);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
}		
