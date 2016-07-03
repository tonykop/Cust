package com.maoguang.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.maoguang.domain.Cust;

public interface CustDao {
/**
 * 根据用户名查找用户
 * @param name
 * @return
 */
	Cust findUserByName(String name);

     void addCust(Cust cust);

	List<Cust> getAllCust();

	Cust findUserById(String id);

	void updateCust(Cust cust);

	void delCust(String id); 

	void delCustByIDWithTrans(Connection conn,String id) throws SQLException;

	int getCountRow();

	List<Cust> getCustByPage(int from, int count);

}
