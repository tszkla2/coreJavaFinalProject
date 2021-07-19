package com.cognixia.jump.corejava.finalproject;

import java.io.Serializable;

public abstract class Human implements Serializable{

	private static final long serialVersionUID = -4678933028170520758L;
		
			private String name;
			
			public String getName() {
				return name;
			}
		
			public void setName(String name) {
				this.name = name;
			}
		
}
