package com.maoguang.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.maoguang.domain.Cust;
import com.maoguang.util.DaoUtils;


public class CustDaoImpl implements CustDao {

	@Override
	public Cust findUserByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select *from customer where name = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<Cust>(Cust.class), name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void addCust(Cust cust) {
		String sql = "insert into customer values (null,?,?,?,?,?,?,?,?)";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql, cust.getName(), cust.getGender(), cust.getBirthday(), cust.getCellphone(),
					cust.getEmail(), cust.getPreference(), cust.getType(), cust.getDescription());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
