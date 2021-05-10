package com.ytooo.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.zip.DeflaterOutputStream;

/**
 * created by kz on
 * @author 匡政
 */

//popularity
//时间
//演员
//导演


//票房-预算
//

//
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	private  static double  leastToTopMovie=300;
	private static double allMovieMeanScore=6.7663077745284665;

	public double getCalWRScore() {
		return calWRScore;
	}

	public double getCalIncome(){
		double dincome;
		double dbudget;
		try{
			dincome= Double.parseDouble(revenue);
			dbudget=Double.parseDouble(budget);
		}catch (Exception e){
			return 0;
		}
		return dincome-dbudget;
	}
	public boolean isFavorite(){
		if(favorityLanguage.isFavorite(originalLanguage)){
			return true;
		}else{
			return false;
		}
	}

	public void setCalWRScore(double calWRScore) {
		this.calWRScore = calWRScore;
	}

	double calWRScore=100;
	public double CalcuWRScore(){
		double dvoteCount,dvoteAverage;
		try{
			dvoteAverage=Double.parseDouble(voteAverage);
			dvoteCount=Double.parseDouble(voteCount);
		}catch (Exception e){
			System.out.println("wrong"+id+"\t"+voteAverage+"\t"+voteCount);
			dvoteAverage=0;
			dvoteCount=0;
		}
		calWRScore=dvoteCount*dvoteAverage/(dvoteCount+leastToTopMovie)+leastToTopMovie*allMovieMeanScore/(dvoteCount+leastToTopMovie);
		return calWRScore;
	}

	public double getCalPopu(){
		double dpopu;
		try {
			dpopu=Double.parseDouble(popularity);
		}catch (Exception e){
			return 0;
		}
		return dpopu;
	}

	@CsvBindByName(column = "budget")
	String	budget;

	@CsvBindByName(column = "genres")
	String genres;

	@CsvBindByName(column = "id")
    String id;

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
	double releaseDate;

	@CsvBindByName(column = "revenue")
	String revenue;

	@CsvBindByName(column = "runtime")
	String runtime;

	@CsvBindByName(column = "spoken_languages")

	String spokenLanguages;


	@CsvBindByName(column = "tagline")
	String tagline;

	@CsvBindByName(column = "title")
	String title;



	@CsvBindByName(column = "vote_average")
	String voteAverage;

	@CsvBindByName(column = "vote_count")
	String voteCount;

	@CsvBindByName(column = "cast")
	String cast;

	@CsvBindByName(column = "director")
	String director;




	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getPopularity() {
		return popularity;
	}

	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}

	public String getProductionCompanies() {
		return productionCompanies;
	}

	public void setProductionCompanies(String productionCompanies) {
		this.productionCompanies = productionCompanies;
	}

	public String getProductionCountries() {
		return productionCountries;
	}

	public void setProductionCountries(String productionCountries) {
		this.productionCountries = productionCountries;
	}

	public double getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(double releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getRevenue() {
		return revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getSpokenLanguages() {
		return spokenLanguages;
	}

	public void setSpokenLanguages(String spokenLanguages) {
		this.spokenLanguages = spokenLanguages;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(String voteAverage) {
		this.voteAverage = voteAverage;
	}

	public String getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(String voteCount) {
		this.voteCount = voteCount;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
}
