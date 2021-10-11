package com.cvv.springboot.h2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.cvv.springboot.h2.model.*;


public class BridgeCrossbyTwoPeople {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> persons = new ArrayList<Person>();
		Person p1 = new Person("a",1);
		Person p2 = new Person("b",10);
		Person p3 = new Person("c",3);
		Person p4 = new Person("d",16);
		Person p5 = new Person("e",11);
		Person p6 = new Person("f",100);
		Person p7 = new Person("g",14);
		Person p8 = new Person("h",23);
		Person p9 = new Person("i",11);
		//Person p10 = new Person("j",19);
		//persons.addAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10));
		persons.addAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9));

		
		Comparator<Person> speedCompare = Comparator.comparing(p->p.getTimeTakenToCrossBridge());
		persons.sort(speedCompare);
		
		System.out.println(persons);
		int leastTimeTaken = 0;
		if(persons.size() % 2 == 0) {
			for(int i=0;i<persons.size();i=i+2){
				leastTimeTaken = leastTimeTaken + persons.get(i+1).getTimeTakenToCrossBridge();
			}
		}else {
			for(int i=0;i<persons.size()-1;i=i+2){
				leastTimeTaken = leastTimeTaken + persons.get(i+1).getTimeTakenToCrossBridge();
			}
			leastTimeTaken = persons.get(0).getTimeTakenToCrossBridge() + persons.get(persons.size()-1).getTimeTakenToCrossBridge();
		}
		System.out.println("leastTimeTaken = "+leastTimeTaken);
	}
}

