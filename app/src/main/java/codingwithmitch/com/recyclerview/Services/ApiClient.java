package codingwithmitch.com.recyclerview.Services;

import android.util.Log;
import android.widget.Toast;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit = null;


    public static Retrofit getApiClient(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        Log.e("api ", " done");
        return retrofit;
    }
}

