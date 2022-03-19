package com.chenjie.core.parser;

public interface Parser<E, T> {
   T parse(E e);
}
