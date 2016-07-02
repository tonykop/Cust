package com.maoguang.dao;

import com.maoguang.domain.Cust;

public interface CustDao {
/**
 * 根据用户名查找用户
 * @param name
 * @return
 */
	Cust findUserByName(String name);

     void addCust(Cust cust);

}