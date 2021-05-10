package com.ytooo.utils;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.thoughtworks.xstream.core.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Author: 王乾
 * Date: 2021/5/10 13:58
 */
@Service
public class csvUtils {
    /**
     * 日志对象
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(csvUtils.class);

    /**
     * 解析csv文件并转成bean
     * @param file csv文件
     * @param clazz 类
     * @param <T> 泛型
     * @return 泛型bean集合
     */
    public <T> List<T> getCsvData(File file, Class<T> clazz) throws FileNotFoundException {
        FileReader fr=new FileReader(file);


        HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(clazz);

        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(fr)
                .withSeparator(';')
                .withQuoteChar('\"')
                .withMappingStrategy(strategy).build();
        return csvToBean.parse();
    }
}
