package com.chenjie.core.project.anjuke;

import lombok.Data;

@Data
public class Loupan {
    private String name;
    private String alias;
    private String lpType;
    private String sale;
    private String desc;
    private String price;
    private String openTime;
    private String checkTime;
    private String address;
	
    public Loupan(String name) { 
    	this.name = name;
    }	
    
	public Loupan() { 
		this(null);
	} 
}
