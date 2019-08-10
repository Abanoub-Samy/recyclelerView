package codingwithmitch.com.recyclerview.Services;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface JsonPlaceHolderApi {



    @GET("posts")
    Call<List<model>> getPosts();

    @GET("posts")
    Call<List<model>> getPosts(
            @Query("id") Integer[] userId,
            @Query("title") String sort,
            @Query("body") String order
    );

    @GET("posts")
    Call<List<model>> getPosts(@QueryMap Map<String, String> parameters);


//    @FormUrlEncoded
//    @POST("register")
//    Call<User> CreateUser(@Body User user);


}