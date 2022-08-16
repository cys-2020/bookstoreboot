package com.cys.boot.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cys.boot.utils.Models;

@RestController
public class TestController {
	@PostMapping("/testJsonArr")
	public void testJsonArr(@RequestBody String jsonarr) {
		System.err.println(jsonarr);
	}
	@PostMapping("/testJsonArr1")
	public void testJsonArr1(@RequestBody ArrayList<String> jsonarr) {
		System.err.println(jsonarr!=null);
		jsonarr.forEach(v->{
			System.err.println(v);
		});
	}
	
	@PostMapping("/testJsonArrField1")
	public void testJsonArrField(@RequestBody String json) {
		System.err.println(json);
		Models m= new Models();
		//{a:obj, b:objtyps}
		String []values= m.getValuesFromCommonJson(json, 2);
		TestClass obj=m.getObjectFromJsonString(values[0], TestClass.class);
		System.err.println(obj);
		ArrayList<String> objtyps=m.getObjectFromJsonString(values[1], ArrayList.class);
		objtyps.forEach(v->{
			System.err.println(v);
		});
	}
}
class TestClass{
	private String title;
	private ArrayList<String> typs;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<String> getTyps() {
		return typs;
	}
	public void setTyps(ArrayList<String> typs) {
		this.typs = typs;
	}
	@Override
	public String toString() {
		return "TestClass [title=" + title + ", typs=" + typs + "]";
	}
	
}
