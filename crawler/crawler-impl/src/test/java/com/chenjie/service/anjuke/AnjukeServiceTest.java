package com.chenjie.service.anjuke;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chenjie.impl.service.AnjuKeService;
import com.chenjie.service.StarterTest;

public class AnjukeServiceTest extends StarterTest{
	@Autowired
	private AnjuKeService anjuKeService;
	
	@Test
	public void capture() { 
		anjuKeService.capture();
	}
}
