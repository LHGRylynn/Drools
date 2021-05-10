package com.ytooo;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.thoughtworks.xstream.core.BaseException;
import com.ytooo.bean.*;
import com.ytooo.model.Movie;
import com.ytooo.utils.csvUtils;
import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class DroolsApplicationTests {

    @Autowired
    private KieSession session;

    @Autowired
    private csvUtils csvReader;

    @Test
    public void redsCsv() throws IOException {
        File file=new File("src/main/resources/movies_metadata.csv");
        List<com.ytooo.model.Movie> data=csvReader.getCsvData(file,com.ytooo.model.Movie.class);
        for (com.ytooo.model.Movie xx:data
             ) {

            session.insert(xx);
        }
    }




    @Test
    public  void getScore(){
        Movie movie=new Movie();
        movie.setId(1);
        movie.setVoteAverage(8.99);
        movie.setVoteCount(2000);
        session.insert(movie);
        session.fireAllRules();


        QueryResults results = session.getQueryResults( "getScoreMovie" );
        System.out.println( "we have " + results.size() + " movie WRscore above  2" );

    }


    @AfterEach
    public void runDispose() {
        session.dispose();//释放资源
    }
}
