import org.arkecosystem.crypto.transactions.builder.AbstractTransactionBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;

public class CertificateDataBuilder extends AbstractTransactionBuilder<CertificateDataBuilder> {
    public CertificateDataBuilder(){
        super();
        this.transaction.fee = 1000000;
    }

    public CertificateDataBuilder certifiedDataAsset(String data){
        this.transaction.asset.customAsset.put("certifiedData",data);
        return this;
    }

    @Override
    public Transaction getTransactionInstance() {
        return new CertificateData();
    }

    @Override
    public CertificateDataBuilder instance() {
        return this;
    }
}
