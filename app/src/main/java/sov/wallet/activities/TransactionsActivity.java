package sov.wallet.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.stellar.sdk.KeyPair;
import org.stellar.sdk.responses.AccountResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

import sov.wallet.R;
import sov.wallet.tasks.AccessAccountTask;

public class TransactionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        String seed = (String) getIntent().getSerializableExtra("seed");

        ((TextView)findViewById(R.id.current_date_text_view)).setText(getFormattedDate());

        findViewById(R.id.receive_button).setOnClickListener(view->{
            runOnUiThread(()->{
                KeyPair pair = KeyPair.fromSecretSeed(seed);
                Intent intent = new Intent(this, ReceiveActivity.class);
                intent.putExtra("accountId", pair.getAccountId());
                startActivity(intent);
            });
        });

        findViewById(R.id.send_button).setOnClickListener(view->{

        });

        runOnUiThread(()-> {
            KeyPair pair = KeyPair.fromSecretSeed(seed);
            try {
                AccountResponse account = new AccessAccountTask().execute(pair).get();
                AccountResponse.Balance[] balances = account.getBalances();
                AccountResponse.Balance balance = balances[0];
                ((TextView)findViewById(R.id.balance_text_view)).setText(balance.getBalance());
            } catch (Throwable e) {
                e.printStackTrace();
            }
        });
    }

    private String getFormattedDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }
}
