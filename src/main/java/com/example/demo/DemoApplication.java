package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


		StringList stringList = new StringListImpl();
		stringList.add("1");
		stringList.add("2");
		stringList.add("3");
		stringList.add("4");

		stringList.add(5, "7");

		stringList.remove(2);
		System.out.println(Arrays.toString(stringList.toArray()));
		stringList.clear();
		System.out.println(stringList.size());
	}

}
