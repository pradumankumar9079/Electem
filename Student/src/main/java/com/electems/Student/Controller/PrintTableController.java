package com.electems.Student.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electems.Student.Service.TableService;

@RestController
@RequestMapping("/printtable")
public class PrintTableController {
	@Autowired
	public TableService tableService;
	
	@GetMapping("/print")
	public List<Integer> printTable(@RequestParam int num){
		return tableService.printTable(num);
	}
	
	
}
