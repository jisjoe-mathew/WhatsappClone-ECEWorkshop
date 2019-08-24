package in.allbing.whatsappclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
    }

    public void login(View view) {
        String u,p;
        u=username.getText().toString();
        p=password.getText().toString();
        if(u.equals("")||p.equals("")){
            Toast.makeText(getApplicationContext(), "Enter all Details", Toast.LENGTH_LONG).show();
        }
        else{
            if(u.equals("jis")&&p.equals("jis")){
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,Home.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(), "Wrong Creds", Toast.LENGTH_LONG).show();
            }
        }
    }
}
