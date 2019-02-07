package sov.wallet;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.stellar.sdk.KeyPair;
import org.stellar.sdk.Network;
import org.stellar.sdk.Server;
import org.stellar.sdk.requests.ErrorResponse;
import org.stellar.sdk.responses.AccountResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class SecretSeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret_seed);
        KeyPair pair = KeyPair.random();

        ((TextView)findViewById(R.id.secret_seed_text_view)).setText(new String(pair.getSecretSeed()));

        findViewById(R.id.access_button).setOnClickListener(view ->{
            Thread thread = new Thread(()->{
                try {
                    AccountResponse response = new AccessAccountTask().execute(pair).get();
                    System.out.println(response);
                } catch(Throwable e){
                    e.printStackTrace();
                }
            });

            thread.start();

        });
    }
}
