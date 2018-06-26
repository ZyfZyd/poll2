package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Options;

public interface IOptionsService {
			//查询
			List<Options>findAll() throws Exception;
			//通过关键字查询
			List<Options> query(String keywords) throws Exception;
			//删除
			void deleteById(long id) throws Exception;
			//添加
			void save(Options options) throws Exception;
			//修改
			void update(Options Options) throws Exception;
			//批量删除
			void batchDelete(List<Long> ids) throws Exception;
}

