package com.maoguang.service;

import java.util.List;

import com.maoguang.dao.CustDao;
import com.maoguang.domain.Cust;
import com.maoguang.factory.BasicFactory;

public class CustServiceImpl implements CustService {

	CustDao dao=BasicFactory.getFactory().getInstance(CustDao.class);
	@Override
	public void addCust(Cust cust) {
		// TODO Auto-generated method stub
		if(dao.findUserByName(cust.getName())!=null){
			throw new RuntimeException("用户名已经存在");
		}
		dao.addCust(cust);
	}
	@Override
	public List<Cust> getAllCust() {
		// TODO Auto-generated method stub
		return dao.getAllCust();
	}
}
