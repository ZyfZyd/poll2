package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.service.IClazzService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clazz")
@Api(description = "班级相关接口")
public class ClazzController {
	@Autowired
	private IClazzService clazzService;

	@GetMapping("findAllClazz")
	@ApiOperation("查询所有的班级信息")
	public MsgResponse findAllClazz() {
		try {
			List<Clazz> list = clazzService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation("通过id删除班级信息")
	@GetMapping("deleteByIdClazz")
	public MsgResponse deleteByIdClazz(long id) {
		try {
			clazzService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
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
			clazzService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}

	}

	@GetMapping("findAllClazzVM")
	@ApiOperation(value = "查询所有的班级信息", notes = "每个班级信息中所属年级和班级所属的班主任的信息")
	public MsgResponse findAllClazzVM() {
		try {
			List<ClazzVM> list = clazzService.findAllClazzVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "保存或更新班级信息", notes = "如果参数中包含id，说明这是一个更新操作，如果没有，这是一个保存操作")
	@PostMapping("saveOrUpdateClazz")
	public MsgResponse saveOrUpdateClazz(Clazz clazz) {
		try {
			if (clazz != null && clazz.getId() != null) {
				clazzService.update(clazz);
				return MsgResponse.success("更新成功", null);
			} else {
				clazzService.save(clazz);
			}
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
