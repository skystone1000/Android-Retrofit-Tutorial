package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.retrofit.model.ChannelModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        // http://lvcms.lokavidya.com//api/v1/channels/details?channel_id=180&user_id=530&org_user_id=406&is_active=true&page=1
        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("http://jsonplaceholder.typicode.com/")
                .baseUrl("http://lvcms.lokavidya.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        // getPosts();

        // getComments();

        // createPost();

        channelResponse();
    }

    private void getPosts(){
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts(5,"id", "desc");

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for(Post post : posts){
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void getComments(){
        Call<List<Comment>> call = jsonPlaceHolderApi.getComments(4);

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

                if(!response.isSuccessful()){
                    textViewResult.setText("Code: "+ response.code());
                    return;
                }

                List<Comment> comments = response.body();

                for(Comment comment : comments){
                    String content = "";
                    content += "ID: " + comment.getId() + "\n";
                    content += "Post ID: " + comment.getPostId() + "\n";
                    content += "Name: " + comment.getName() + "\n";
                    content += "Email: " + comment.getEmail() + "\n";
                    content += "Text: " + comment.getText() + "\n";
                    content += "\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void createPost(){
        // http://lvcms.lokavidya.com//api/v1/channels/details?channel_id=180&user_id=530&org_user_id=406&is_active=true&page=1

        // Way 1
        // Post post = new Post(23,"New Title","new text");
        // Call<Post> call = jsonPlaceHolderApi.createPost(post);

        // Way 2
        // Call<Post> call = jsonPlaceHolderApi.createPost(23,"New Title","new text");

        // Way 3
        Map<String, String> fields = new HashMap<>();
        fields.put("userId", " 25");
        fields.put("title","new Title");
        Call<Post> call = jsonPlaceHolderApi.createPost(fields);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                Post postResponse = response.body();

                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Text: " + postResponse.getText() + "\n";

                textViewResult.append(content);


            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void channelResponse1(){
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts(5,"id", "desc");

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for(Post post : posts){
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void channelResponse(){
        // http://lvcms.lokavidya.com//api/v1/channels/details?channel_id=180&user_id=530&org_user_id=406&is_active=true&page=1
        // http://lvcms.lokavidya.com/api/v1/channels/details?channel_id=180&user_id=530&org_user_id=406&is_active=true&page=1

        // Way 1
        // Post post = new Post(23,"New Title","new text");
        // Call<Post> call = jsonPlaceHolderApi.createPost(post);

        // Way 2
         Call<ChannelModel> call = jsonPlaceHolderApi.channelResponse("pZby6lsJWryBO8X2MTrT6gtt",180,530, 406, true,1);

        // Way 3
        /*Map<String, String> fields = new HashMap<>();
        fields.put("userId", " 25");
        fields.put("title","new Title");
        Call<Post> call = jsonPlaceHolderApi.createPost(fields);*/

        call.enqueue(new Callback<ChannelModel>() {
            @Override
            public void onResponse(Call<ChannelModel> call, Response<ChannelModel> response) {
                System.out.println(call.request().url());

                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                ChannelModel postResponse = response.body();

                /*String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Text: " + postResponse.getText() + "\n";*/

                textViewResult.append(postResponse.toString());
            }

            @Override
            public void onFailure(Call<ChannelModel> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }

}