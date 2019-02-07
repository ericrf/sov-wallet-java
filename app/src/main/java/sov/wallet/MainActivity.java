package sov.wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.access_account_button).setOnClickListener((view)-> {
            startActivity(new Intent(this, AccessAccountActivity.class));
        });

        findViewById(R.id.create_account_button).setOnClickListener((view)-> {
            startActivity(new Intent(this, SecretSeedActivity.class));
        });
    }


}
