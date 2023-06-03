package com.DAO;

import java.util.List;

import com.entity.ShopDtls;

public interface ShopDAO {

	public boolean shopRegister(ShopDtls s);

	public ShopDtls login(String em, String ps);

	public boolean checkUser(String em);

	public List<ShopDtls> getShop();

	public boolean update(ShopDtls s);
	
	public boolean checkPassword(int id, String ps);
	
	public ShopDtls getShopById(int id);
	
}
