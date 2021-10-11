package com.cvv.springboot.h2.model;

public class Person implements Comparable<Person> {
	private String name;
	private Integer timeTakenToCrossBridge;

	public Person(String name, Integer timeTakenToCrossBridge) {
		this.name = name;
		this.timeTakenToCrossBridge = timeTakenToCrossBridge;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTimeTakenToCrossBridge() {
		return timeTakenToCrossBridge;
	}

	public void setTimeTakenToCrossBridge(Integer timeTakenToCrossBridge) {
		this.timeTakenToCrossBridge = timeTakenToCrossBridge;
	}

	@Override
	  public int compareTo(Person p) {
		return timeTakenToCrossBridge - p.getTimeTakenToCrossBridge();
	  }

	@Override
	public String toString() {
		return timeTakenToCrossBridge + "-" + name;
	}
}
