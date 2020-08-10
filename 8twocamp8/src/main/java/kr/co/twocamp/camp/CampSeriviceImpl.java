package kr.co.twocamp.camp;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;



@Service
public class CampSeriviceImpl implements CampService {

	@Inject
	CampDAO campDAO;

	@Override
	public List<CampBean> camplist() {
		// TODO Auto-generated method stub
		return campDAO.camplist();
	}








}
