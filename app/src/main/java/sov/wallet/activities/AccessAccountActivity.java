package sov.wallet.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import sov.wallet.R;

public class AccessAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_account);

        findViewById(R.id.access_button).setOnClickListener(view ->{
            runOnUiThread(()->{
                String seed = ((EditText) findViewById(R.id.secret_seed_text)).getText().toString();
                Intent intent = new Intent(this, TransactionsActivity.class);
                intent.putExtra("seed", seed);
                startActivity(intent);
            });
        });
    }
}
