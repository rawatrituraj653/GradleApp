package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;

@Repository
public class ItemDaoImpl implements IItemDao{
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveItem(Item item) {
			
			Integer id=(Integer) ht.save(item);
		
		return id;
	}

	@Override
	public Item getItem(Integer id) {
			Item item=ht.get(Item.class, id);
		return item;
	}

	@Override
	public List<Item> getAllItem() {
			List<Item> items=ht.loadAll(Item.class);
		return items;
	}

	@Override
	public String updateItem(Item item) {
		ht.update(item);
		return "Item Data Updated Successfully.......";
	}

	@Override
	public String deleteItem(Item item) {
		ht.delete(item);
		return "Item Data Deleted Sucessfully..........";
	}
}
