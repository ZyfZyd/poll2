package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.service.IUserService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(description = "用户相关接口")
public class UserController {
	@Autowired
	private IUserService userService;

	@ApiOperation(value = "查询所有用户信息")
	@GetMapping("findAllUser")
	public MsgResponse findAllUser() {
		try {
			List<User> list = userService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "通过id删除用户信息")
	@GetMapping("deleteByIdUser")
	public MsgResponse deleteByIdUser(long id) {
		try {
			userService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "保存或更新用户信息", notes = "如果参数中包含id，说明这是一个更新操作，如果没有，这是一个保存操作")
	@PostMapping("saveOrUpdateUser")
	public MsgResponse saveOrUpdateUser(User user) {
		try {
			if (user != null && user.getId() != null) {
				userService.update(user);
				return MsgResponse.success("更新成功", null);
			} else {
				userService.save(user);
			}
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation("通过关键字查询教师信息")
	@GetMapping("findAllUserBykeywords")
	public MsgResponse findAllUserBykeywords(String keywords) {
		try {
			List<User> list = userService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	
	@ApiOperation(value = "通过id组批量删除班级信息")
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids) {
		try {
			List<Long> idList = new ArrayList<>();
			for (long id : ids) {
				idList.add(id);
			}
			userService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}

	}
}
