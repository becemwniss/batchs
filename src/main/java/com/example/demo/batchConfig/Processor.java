package com.example.demo.batchConfig;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created by pc-becem on 9/10/2017.
 */
public class Processor implements ItemProcessor<String, String> {
    @Override
    public String process(String s) throws Exception {
        return s;
    }
}
