package in.allbing.whatsappclone;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
TextView tv;
TabLayout tab_layout;
FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
}
