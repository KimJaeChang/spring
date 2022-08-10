package com.kjcspring.dao;

import java.util.List;

import com.kjcspring.model.KjcVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KjcDAO {
	public List<KjcVO> selectkjcList();
}
