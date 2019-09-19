package com.app.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IItemDao;
import com.app.model.Item;
import com.app.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService{

	@Autowired
	private IItemDao dao;
	
	@Override
	@Transactional
	public Integer saveItem(Item item) {
		if(item!=null) {
			return dao.saveItem(item);
			
		}	
		return -1;
	}

	@Override
	@Transactional(readOnly = true)
	public Item getItem(Integer id) {
		Item item=dao.getItem(id);
		if(item!=null) {
			return item;
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Item> getAllItem() {
		
		return dao.getAllItem();
	}

	@Override
	@Transactional
	public String updateItem(Item item) {
		if(item!=null) {
		Item dbItem=dao.getItem(item.getItemId());
		if(dbItem!=null) {
			return dao.updateItem(dbItem);
		}else 
			return "Item Data is not Avilable in Database...!!";
		}
		else
		return "Send Item Data then We perform Upadte";
	}

	@Override
	@Transactional
	public String deleteItem(Integer itemId) {
		if(itemId!=null) {
			Item dbItem=dao.getItem(itemId);
			if(dbItem!=null) {
				return dao.deleteItem(dbItem);
			}else 
				return "Item Data is not Avilable in Database...!!";
			}
			else
			return "Send Item Id then We perform Delete";
		}
		
}


