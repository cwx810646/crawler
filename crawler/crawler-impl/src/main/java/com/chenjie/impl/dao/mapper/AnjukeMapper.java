package com.chenjie.impl.dao.mapper;

import java.util.List; 

import com.chenjie.core.project.anjuke.Loupan;
 
public interface AnjukeMapper {
    void batchInsert(List<Loupan> loupans);
}
