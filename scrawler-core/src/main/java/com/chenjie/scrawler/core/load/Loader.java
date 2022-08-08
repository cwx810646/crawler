package com.chenjie.scrawler.core.load;

/**
 * <源数据加载器>
 *
 * @author chenjie
 * @since 2022-08-08
 */
public interface Loader<I, V> {
    /**
     *  加载原数据方法
     *
     * @param p 输入信息
     * @return 输出结果
     */
    V load(I p);
}
