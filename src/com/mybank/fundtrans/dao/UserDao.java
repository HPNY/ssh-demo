package com.mybank.fundtrans.dao;

import com.mybank.fundtrans.domain.User;

public interface UserDao {	
	User login(String name,String password);
}
