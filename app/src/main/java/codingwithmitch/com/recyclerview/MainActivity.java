package codingwithmitch.com.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import codingwithmitch.com.recyclerview.Services.ApiClient;
import codingwithmitch.com.recyclerview.Services.JsonPlaceHolderApi;
import codingwithmitch.com.recyclerview.Services.model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars

    JsonPlaceHolderApi jsonPlaceHolderApi;
    ArrayList<Integer> arr_id ;
    ArrayList<String> arr_title ;
    ArrayList<String> arr_body  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");
        arr_id = new ArrayList<>();
        arr_title = new ArrayList<>();
        arr_body  = new ArrayList<>();

        initImageBitmaps();
    }

    private void initImageBitmaps(){




        jsonPlaceHolderApi = ApiClient.getApiClient().create(JsonPlaceHolderApi.class);


        //createUser();
        Call<List<model>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                List<model> posts = response.body();
                
                for (model post : posts) {

                    arr_id.add(post.getId());
                    arr_title.add(post.getTitle());
                    //arr_body.add(post.getBody());
                    //Toast.makeText(MainActivity.this, arr_id.size(), Toast.LENGTH_SHORT).show();
                }
//                arr_title.add("fady");
//                arr_id.add(3);
            }

            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "some thing wrong", Toast.LENGTH_SHORT).show();
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.e(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arr_id, arr_title,arr_body);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}






















