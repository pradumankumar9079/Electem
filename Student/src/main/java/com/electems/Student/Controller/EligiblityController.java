package com.electems.Student.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electems.Student.Service.Eligible;

@RestController
@RequestMapping("/eligible")
public class EligiblityController {
	
	@Autowired
	public Eligible eligible;
	
	@GetMapping("/driving")
	public boolean isEligible(@RequestParam int age) {
		return eligible.isEligibleForDriving(age);
	}
}
