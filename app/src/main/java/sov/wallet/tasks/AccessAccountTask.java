package sov.wallet.tasks;

import android.os.AsyncTask;

import org.stellar.sdk.KeyPair;
import org.stellar.sdk.requests.ErrorResponse;
import org.stellar.sdk.responses.AccountResponse;

import java.io.IOException;

import sov.wallet.util.StellarServer;

public class AccessAccountTask extends AsyncTask<KeyPair, Void, AccountResponse> {
    @Override
    protected AccountResponse doInBackground(KeyPair... pairs) {
        try {
            return StellarServer.getInstance().accounts().account(pairs[0]);
        } catch(ErrorResponse e){
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
