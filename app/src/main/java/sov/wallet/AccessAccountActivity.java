package sov.wallet;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import org.stellar.sdk.KeyPair;
import org.stellar.sdk.responses.AccountResponse;

import java.util.concurrent.ExecutionException;

public class AccessAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_account);

        findViewById(R.id.access_button).setOnClickListener(view ->{
            Thread thread = new Thread(()->{
                try {
                    String seed = ((EditText )findViewById(R.id.secret_seed_text)).getText().toString();
                    KeyPair pair = KeyPair.fromSecretSeed(seed);

                    AccountResponse response = new AccessAccountTask().execute(pair).get();
                    System.out.println(response);
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            });

            thread.start();



        });
    }
}
