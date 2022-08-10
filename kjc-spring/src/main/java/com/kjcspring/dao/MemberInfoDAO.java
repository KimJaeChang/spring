package com.kjcspring.dao;

import com.kjcspring.model.MemberInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberInfoDAO {

	public MemberInfo selectMemberInfo(MemberInfo memberInfo);

}
