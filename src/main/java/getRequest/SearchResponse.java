package getRequest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResponse {

    @JsonProperty("Search")
    private List <MovieResponse> search;
    @JsonProperty("totalResults")
    private String totalResults;
    @JsonProperty("Response")
    private String response;

    public List<MovieResponse> getSearch() {
        return search;
    }
    public void setSearch(List<MovieResponse> search) {
        this.search = search;
    }
    public String getTotalResults() {
        return totalResults;
    }
    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }
    public String getResponse() {
        return response;
    }
    public void setResponse(String response) {
        this.response = response;
    }

}
