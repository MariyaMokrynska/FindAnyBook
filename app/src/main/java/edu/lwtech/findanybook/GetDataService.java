/**
 * Mariya Mokrynska
 */
package edu.lwtech.findanybook;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {
    @GET("volumes")
    Call<SearchResult> getSearchResult(@Query("q") String searchQuery, @Query("maxResults") int n);
}
