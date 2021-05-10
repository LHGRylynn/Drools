package com.ytooo.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by kz on
 * @author 匡政
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
//	private  static double  leastToTopMovie=50;
//	private static double allMovieMeanScore=3.328;

	@CsvBindByName(column = "budget")
	int	budget;
	@CsvBindByName(column = "genres")
	String genres;
	@CsvBindByName(column = "id")
    int id;

	@CsvBindByName(column = "original_language")
    String originalLanguage;
	@CsvBindByName(column = "original_title")
	String originalTitle;

	@CsvBindByName(column = "popularity")
    String popularity;
	@CsvBindByName(column = "production_companies")
	String productionCompanies;
	@CsvBindByName(column = "production_countries")
	String productionCountries;

	@CsvBindByName(column = "release_date")
	String releaseDate;

	@CsvBindByName(column = "revenue")
	int revenue;

	@CsvBindByName(column = "runtime")
	int runtime;

	@CsvBindByName(column = "spoken_languages")

	String spokenLanguages;


	@CsvBindByName(column = "tagline")
	String tagline;

	@CsvBindByName(column = "title")
	String title;
	@CsvBindByName(column = "vote_average")
	int voteAverage;

	@CsvBindByName(column = "vote_count")
	int voteCount;

//	@CsvBindByName(column = "cast")
//	String cast;
//
//	@CsvBindByName(column = "director")
//	String director;

}
