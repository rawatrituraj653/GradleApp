package com.app.dao;

import java.util.List;

import com.app.model.Item;

public interface IItemDao {

	public Integer saveItem(Item item);
	public Item getItem(Integer id);
	public List<Item> getAllItem();
	public String updateItem(Item item);
	public String deleteItem(Item item);
	
	
	
}
