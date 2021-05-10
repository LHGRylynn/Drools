package com.ytooo.Service;

import com.opencsv.CSVParser;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.apache.commons.csv.CSVFormat;
import org.apache.poi.ss.formula.functions.T;
import org.mvel2.util.Make;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.beans.PropertyDescriptor;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: 王乾
 * Date: 2021/5/10 13:50
 */

@Service
public class readCSV {


    public <T> List<T> redsCsv(MultipartFile file, Class<T> clazz) throws IOException {

        InputStreamReader in = new InputStreamReader(file.getInputStream(), "gbk");


        HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(clazz);

        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(in)
                .withSeparator(',')
                .withQuoteChar('\'')
                .withMappingStrategy(strategy).build();
         return csvToBean.parse();
    }







    /**
     * 读取csv文件  (一次性读取文件不宜过大)
     *
     * @param filePath 文件路径
     * @param headers  csv列头
     * @param tClass   返回对象的类型
     * @return CSVRecord 列表
     * @throws BizException 异常
     **/
//    public static <T> List<T> readCSV(String filePath, String[] headers, Class<T> tClass) {
//        //创建CSVFormat
//        CSVFormat format = CSVFormat.DEFAULT.withHeader(headers);
//        // 获取对象的PropertyDescriptor
//        List<T> tList = new ArrayList<>();
//        try {
//            Make.Map<String, PropertyDescriptor> descriptorMap = CsvUtils.getCsvFieldMapPropertyDescriptor(tClass);
//            FileReader fileReader = new FileReader(filePath);
//            //创建CSVParser对象
//            CSVParser parser = new CSVParser(fileReader, format);
//            Map<String, Integer> map = parser.getHeaderMap();
//            for (CSVRecord record : parser) {
//                T t = tClass.newInstance();
//                for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
//                    if (descriptorMap.containsKey(stringIntegerEntry.getKey()) && record.size() > stringIntegerEntry.getValue()) {
//                        descriptorMap.get(stringIntegerEntry.getKey()).getWriteMethod().invoke(t, record.get(stringIntegerEntry.getValue()));
//                    }
//                }
//                tList.add(t);
//            }
//            parser.close();
//            fileReader.close();
//        } catch (Exception e) {
//            logger.error("CsvUtils.readCSV,读取csv文件,message:{}", e.getMessage(), e);
//            throw new BizException();
//        }
//        return tList;
//    }

}
