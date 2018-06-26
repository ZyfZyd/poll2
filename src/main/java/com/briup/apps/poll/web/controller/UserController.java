package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.service.IUserService;
import com.briup.apps.poll.util.MsgResponse;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
    //查询
	@GetMapping("findAllUser")
	public MsgResponse findAllUser(){
		try{
			List<User> list=userService.findAll();
			return MsgResponse.success("success",list);
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

//添加
	@PostMapping("saveUser")
	public MsgResponse saveUser(User user){
		try {
			userService.save(user);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	//修改
		@PostMapping("updateClazz")
		public MsgResponse updateUser(User user){
			try {
				userService.update(user);
				return MsgResponse.success("修改成功", null);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		//删除
		@GetMapping("deleteByIdUser")
		public MsgResponse deleteByIdUser(long id){
			try {
				userService.deleteById(id);
				return MsgResponse.success("删除成功", null);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
}		
