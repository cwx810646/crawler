package com.chenjie.scrawler.core.load.web;

import com.chenjie.scrawler.core.load.Loader;

/**
 * <网页的加载器>
 *
 * @author chenjie
 * @since 2022-08-08
 */
public interface WebLoader extends Loader<String, String> {
    @Override
    String load(String url);
}
