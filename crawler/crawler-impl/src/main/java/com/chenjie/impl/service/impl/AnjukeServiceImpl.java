package com.chenjie.impl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenjie.core.project.anjuke.AnjukeLoader;
import com.chenjie.core.project.anjuke.AnjuleParser;
import com.chenjie.core.project.anjuke.Loupan;
import com.chenjie.impl.dao.mapper.AnjukeMapper;
import com.chenjie.impl.service.AnjuKeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AnjukeServiceImpl implements AnjuKeService {

	@Autowired
	private AnjukeMapper anjukeMapper;

	@Override
	public void capture() {
		init();
		log.info(" ------------- anjuke capture data start -------------");
		long startTime = System.currentTimeMillis();
		String url = "https://xa.fang.anjuke.com/loupan/xixianxinqu/";
		AnjukeLoader loader = new AnjukeLoader(url);
		List<String> htmls = loader.load();
		AnjuleParser anjuleParser = new AnjuleParser();
		List<Loupan> loupans = new ArrayList<>();
		for (String html : htmls) {
			loupans.addAll(anjuleParser.parse(html));
		}
		log.info(" ------------- anjuke capture data end, data size {}, cose time {} s, ", loupans.size(),
				(System.currentTimeMillis() - startTime) / 1000);  
		anjukeMapper.batchInsert(loupans);
	}

	public static void init() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\learn\\code\\github\\crawler\\crawler\\webdrivers\\chromedriver.exe");
	}
}
