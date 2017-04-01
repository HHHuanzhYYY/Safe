package com.temp.util.test;

import com.temp.po.Po;

public class DemoChild extends Po {

	private long secondId;
	
	private Demo demo;

	public DemoChild() {}

	@Override
	public String toString() {
		return "DemoChild [secondId=" + secondId + ", demo=" + demo + "]";
	}

	public long getSecondId() {
		return secondId;
	}

	public void setSecondId(long secondId) {
		this.secondId = secondId;
	}

	public Demo getDemo() {
		return demo;
	}

	public void setDemo(Demo demo) {
		this.demo = demo;
	}
	
}
