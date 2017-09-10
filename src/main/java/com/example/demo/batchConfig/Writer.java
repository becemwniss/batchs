package com.example.demo.batchConfig;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by pc-becem on 9/10/2017.
 */
public class Writer implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> list) throws Exception {
            list.forEach(
                    s -> System.out.println(s)
            );
    }
}
