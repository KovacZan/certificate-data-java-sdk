import org.arkecosystem.crypto.transactions.types.Transaction;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;

public class CertificateManager extends Transaction {

    @Override
    public int getTransactionType() {
        return BCDiplomaTransactionTypes.CERTIFICATE_MANAGER.getValue();
    }

    @Override
    public int getTransactionTypeGroup() {
        return 1002;
    }

    @Override
    public HashMap<String, Object> assetToHashMap() {
        HashMap<String, Object> asset = new HashMap<>();
        HashMap<String, Object>  certifiedData = new HashMap<>();
        certifiedData.put("data", this.asset.customAsset.get("certifiedData"));
        asset.put("certifiedData",certifiedData);
        return asset;
    }

    @Override
    public byte[] serialize() {
        String certificateData = (String) this.asset.customAsset.get("certifiedData");
        byte[] certificateDataBuffer = certificateData.getBytes();

        ByteBuffer buffer = ByteBuffer.allocate(2 + certificateDataBuffer.length);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        buffer.putShort((short) certificateDataBuffer.length);
        buffer.put(certificateDataBuffer);

        return buffer.array();
    }

    @Override
    public void deserialize(ByteBuffer byteBuffer) {
        short certificateDataLength = byteBuffer.getShort();
        byte[] certificateDataBytes = new byte[certificateDataLength];
        byteBuffer.get(certificateDataBytes);

        this.asset.customAsset.put("certifiedData", new String(certificateDataBytes));

    }
}
