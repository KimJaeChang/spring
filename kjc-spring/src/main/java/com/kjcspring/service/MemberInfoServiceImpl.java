package com.kjcspring.service;

import com.kjcspring.dao.MemberInfoDAO;
import com.kjcspring.model.MemberInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberInfoServiceImpl implements MemberInfoService {

    @Autowired
    private MemberInfoDAO memberInfoDAO;

    public MemberInfo selectMemberInfo(MemberInfo memberInfo) {
        return memberInfoDAO.selectMemberInfo(memberInfo);
    }
}
