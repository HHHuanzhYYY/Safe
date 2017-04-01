package com.temp.util.test;

import com.temp.po.Po;

public class Demo extends Po{

	private long id;
	
	private String name;
	
	private String address;

	public Demo() {}

	@Override
	public String toString() {
		return "Demo [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
