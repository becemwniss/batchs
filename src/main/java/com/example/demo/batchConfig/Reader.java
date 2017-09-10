package com.example.demo.batchConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * Created by pc-becem on 9/10/2017.
 */
public class Reader implements ItemReader<String> {

    private String[] messages = {"Hello World!", "Welcome to Spring Batch!"};

    private int count=0;

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public String read() throws Exception {
        if(count < messages.length){
            return messages[count++];
        }else{
            count=0;
        }
        return null;
    }
}
