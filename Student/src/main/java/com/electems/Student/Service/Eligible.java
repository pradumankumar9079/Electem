package com.electems.Student.Service;

import org.springframework.stereotype.Service;

@Service
public class Eligible {
	public boolean isEligibleForDriving(int age) {
		return age>=18;
	}
}
