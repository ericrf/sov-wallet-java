package sov.wallet.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.stellar.sdk.KeyPair;
import org.stellar.sdk.responses.AccountResponse;

import sov.wallet.R;
import sov.wallet.tasks.AccessAccountTask;

public class SecretSeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret_seed);

        runOnUiThread(()->{
            KeyPair pair = KeyPair.random();
            ((TextView)findViewById(R.id.secret_seed_text_view)).setText(new String(pair.getSecretSeed()));
        });

        findViewById(R.id.access_button).setOnClickListener(view ->{
            runOnUiThread(()->{
                try {
                    String seed = ((TextView)findViewById(R.id.secret_seed_text_view)).getText().toString();
                    KeyPair pair = KeyPair.fromSecretSeed(seed);
                    AccountResponse response = new AccessAccountTask().execute(pair).get();
                    System.out.println(response);
                } catch(Throwable e){
                    e.printStackTrace();
                }
            });
        });
    }
}
