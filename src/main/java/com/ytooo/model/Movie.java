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
	private  static double  leastToTopMovie=50;
	private static double allMovieMeanScore=3.328;
	double WRscore;
	public double CalcuWRScore(){
		WRscore=(voteCount)*voteAverage/(voteCount+leastToTopMovie)+(leastToTopMovie)*allMovieMeanScore/(voteCount+leastToTopMovie);
		return WRscore;
	}
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
	double voteAverage;

	@CsvBindByName(column = "vote_count")
	int voteCount;

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
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

	public double getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

//	@CsvBindByName(column = "cast")
//	String cast;
//
//	@CsvBindByName(column = "director")
//	String director;

}
