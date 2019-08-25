package in.allbing.whatsappclone;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home extends AppCompatActivity {
    TextView tv;
    TabLayout tab_layout;
    FloatingActionButton fab;

    RecyclerView recyclerView;
    ChatAdapter chatAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.rv_chat);

        getData();

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        tv=findViewById(R.id.tv);
        tab_layout=findViewById(R.id.tabLayout);
        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home.this, "FAB Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getText().equals("CHATS")){
                    tv.setText("CHATS CLICKED");
                }
                else if(tab.getText().equals("STATUS")){
                    tv.setText("STATUS CLICKED");

                }else if(tab.getText().equals("CALLS")){
                    tv.setText("CALLS CLICKED");

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void getData(){

        String BASE_URL = "https://api.myjson.com/bins/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Api api = retrofit.create(Api.class);

        Call<List<ChatModel>> call =api.getAllChats();

        call.enqueue(new Callback<List<ChatModel>>() {
            @Override
            public void onResponse(Call<List<ChatModel>> call, Response<List<ChatModel>> response) {
                loadData(response.body());
            }

            @Override
            public void onFailure(Call<List<ChatModel>> call, Throwable t) {

            }
        });
    }

    public void loadData(List<ChatModel> chatModelList){

        chatAdapter = new ChatAdapter(this, chatModelList);
        recyclerView.setAdapter(chatAdapter);
    }
}
