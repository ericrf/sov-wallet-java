package sov.wallet.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.stellar.sdk.Network;

import sov.wallet.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Network.useTestNetwork();
        findViewById(R.id.access_account_button).setOnClickListener((view)-> {
            startActivity(new Intent(this, AccessAccountActivity.class));
        });

        findViewById(R.id.create_account_button).setOnClickListener((view)-> {
            startActivity(new Intent(this, SecretSeedActivity.class));
        });
    }


}
