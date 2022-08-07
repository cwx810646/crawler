package com.chenjie.impl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenjie.core.project.anjuke.AnjukeCrawler;
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
		String url = "https://xa.fang.anjuke.com/loupan/xixianxinqu/";
		AnjukeCrawler crawler = new AnjukeCrawler(url);
		List<Loupan> loupans = crawler.run();
		anjukeMapper.batchInsert(loupans);
	}
}
