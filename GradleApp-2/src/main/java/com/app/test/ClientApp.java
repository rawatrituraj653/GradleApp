package com.app.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.AppConfig;
import com.app.model.Item;
import com.app.service.IItemService;
import com.app.service.impl.ItemServiceImpl;

public class ClientApp {

	public static void main(String[] args) {
	
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		IItemService service=context.getBean("itemServiceImpl",IItemService.class);
		Item item=new Item();
		item.setItemId(101);
		item.setItemName("Laptop");
		item.setItemType("Eletronics");
		item.setItemPrice(15250.00);
		item.setMfgDate(new Date());
		
		Item item1=new Item();
		item1.setItemId(102);
		item1.setItemName("Mobile");
		item1.setItemType("Eletronics");
		item1.setItemPrice(9999.00);
		item1.setMfgDate(new Date());
		Integer id=service.saveItem(item);
		Integer id1=service.saveItem(item1);
		System.out.println("Item  Data Saved Successfully...:: "+id);
		System.out.println("Item  Data Saved Successfully...:: "+id1);
	}
}
