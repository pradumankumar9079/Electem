package com.electems.Student.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TableService {
	public List<Integer> printTable(int num){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<=10; i++) {
			list.add(i*num);
		}
		return list;
	}
}
