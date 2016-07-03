package com.maoguang.service;

import java.util.List;

import com.maoguang.domain.Cust;

public interface CustService {

	void addCust(Cust cust);

	List<Cust> getAllCust();

	Cust findCustById(String id);

	void updateCust(Cust cust);

	void delCust(String id);

	void batchDel(String[] ids);

}
