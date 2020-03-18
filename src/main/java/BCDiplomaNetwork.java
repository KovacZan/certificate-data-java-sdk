import org.arkecosystem.crypto.networks.INetwork;

public class BCDiplomaNetwork implements INetwork {
    @Override
    public int version() {
        return 70;
    }

    @Override
    public int wif() {
        return 201;
    }

    @Override
    public String epoch() {
        return "2020-02-05T05:00:00.000Z";
    }
}
