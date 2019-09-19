package com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="item_tab")
public class Item {

	@Id
	@GeneratedValue
	private Integer itemId;
	@Column(length =20)
	private String itemName;
	@Column(length =20)
	private String itemType;
	private Double itemPrice;
	@Temporal(TemporalType.DATE)
	private Date MfgDate;
	
}
