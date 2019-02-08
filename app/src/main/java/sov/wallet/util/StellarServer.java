package sov.wallet.util;

import org.stellar.sdk.Server;

public class StellarServer {
    private static Server instance;
    private StellarServer(){}
    public static Server getInstance(){
        if(instance == null)
            instance = new Server(Constants.TESTNET);
        return instance;
    }
}
