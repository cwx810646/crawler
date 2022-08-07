package com.chenjie.anjuke;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chenjie.impl.service.AnjuKeService;
import com.chenjie.ApplicationTest;

public class AnjukeServiceTest extends ApplicationTest {
	@Autowired
	private AnjuKeService anjuKeService;
	
	@Test
	public void capture() { 
		anjuKeService.capture();
	}
}
