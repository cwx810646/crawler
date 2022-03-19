package com.chenjie.core.parsers;

public interface Parser<E, T> {
   T parse(E e);
}
