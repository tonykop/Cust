package com.maoguang.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.maoguang.dao.CustDao;
import com.maoguang.domain.Cust;
import com.maoguang.factory.BasicFactory;
import com.maoguang.util.DaoUtils;

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
	@Override
	public Cust findCustById(String id) {
		// TODO Auto-generated method stub
		return dao.findUserById(id);
	}
	@Override
	public void updateCust(Cust cust) {
		// TODO Auto-generated method stub
		dao.updateCust(cust);
	}
	@Override
	public void delCust(String id) {
		// TODO Auto-generated method stub
		dao.delCust(id);
	}
	@Override
	public void batchDel(String[] ids) {
		// TODO Auto-generated method stub
		Connection conn=DaoUtils.getConn();
		try {
			conn.setAutoCommit(false);
			for(String id:ids){
				dao.delCustByIDWithTrans(conn,id);
			}
			DbUtils.commitAndCloseQuietly(conn);
		} catch (Exception e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}
