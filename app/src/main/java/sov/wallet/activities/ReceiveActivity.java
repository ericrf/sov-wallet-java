package sov.wallet.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import sov.wallet.R;

public class ReceiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        String accountId = (String) getIntent().getSerializableExtra("accountId");
        ((TextView)findViewById(R.id.account_id_text_view)).setText(accountId);
    }
}
