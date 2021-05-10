package com.ytooo;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.thoughtworks.xstream.core.BaseException;

import com.ytooo.model.Movie;
import com.ytooo.utils.csvUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.File;
import java.io.IOException;

import java.util.Comparator;
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
        File file=new File("src/main/resources/merge(1).csv");
        List<com.ytooo.model.Movie> data=csvReader.getCsvData(file,com.ytooo.model.Movie.class);
        System.out.println();
        for (com.ytooo.model.Movie xx:data
        ) {
            System.out.println(xx.getId());
            session.insert(xx);
        }
        session.fireAllRules();

        data.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                if(o1.getCalWRScore()-o2.getCalWRScore()>0){
                    return -1;
                }else if(o1.getCalWRScore()-o2.getCalWRScore()==0){
                    return 0;
                }else {
                    return  1;
                }

            }
        });


        for (int i = 0; i < 100; i++) {
            System.out.println(i+"\t"+ data.get(i).getId()+"\t"+data.get(i).getOriginalTitle()+"\t"+data.get(i).getCalWRScore());
        }
    }

    @Test
    public void te(){

    }


    @Test
    public  void getScore(){
        Movie movie=new Movie();
        movie.setId("1");
        movie.setVoteAverage("8.99");
        movie.setVoteCount("2000");
        movie.setPopularity("15");
        movie.setReleaseDate(3);
        session.insert(movie);
        session.fireAllRules();
        System.out.println(movie.getCalWRScore());
        System.out.println(movie.getCalWRScore()>5);

        QueryResults results = session.getQueryResults( "getScoreMovie" );
        System.out.println( "we have " + results.size() + " movie WRscore above  2" );

    }


    @AfterEach
    public void runDispose() {
        session.dispose();//释放资源
    }
}
