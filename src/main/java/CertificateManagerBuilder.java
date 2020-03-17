import org.arkecosystem.crypto.transactions.builder.AbstractTransactionBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;

public class CertificateManagerBuilder extends AbstractTransactionBuilder<CertificateManagerBuilder> {
    public CertificateManagerBuilder(){
        super();
        this.transaction.fee = 1000000;
    }

    public CertificateManagerBuilder certifiedDataAsset(String data){
        this.transaction.asset.customAsset.put("certifiedData",data);
        return this;
    }

    @Override
    public Transaction getTransactionInstance() {
        return new CertificateManager();
    }

    @Override
    public CertificateManagerBuilder instance() {
        return this;
    }
}
