package com.kjcspring.service;

import com.kjcspring.dao.KjcDAO;
import com.kjcspring.model.KjcVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KjcServiceImpl implements KjcService {

    @Autowired
    private KjcDAO kjcDAO;

    @Override
    public List<KjcVO> selectkjcList() {
        return kjcDAO.selectkjcList();
    }
}
