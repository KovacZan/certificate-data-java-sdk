import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.Connection;
import org.arkecosystem.crypto.configuration.Network;
import org.arkecosystem.crypto.identities.Address;
import org.arkecosystem.crypto.transactions.types.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static long getNonce(Connection connection, String senderWallet) throws IOException {
        return Long.valueOf (((LinkedTreeMap<String, Object>) connection.api().wallets.show(senderWallet).get("data")).get("nonce").toString());
    }

    public static void main(String[] args) throws IOException {
        Network.set(new BCDiplomaNetwork());

        HashMap<String, Object> map = new HashMap<>();
        map.put("host", "http://49.12.15.12:4003/api/");
        map.put("content-type","application/json");

        Connection connection = new Connection(map);

        long nonce = getNonce(connection, Address.fromPassphrase("allow unveil slide steak glimpse long hurt trend acid stereo equip clump")) + 1;

        ArrayList<HashMap> payload = new ArrayList<>();

        Transaction transaction = new CertificateDataBuilder()
                .nonce(nonce)
                .certifiedDataAsset("784d683468305177545032464a72706e316d366e545a3059522b65576d304938696f4a5a3054435557454d64697a61435975656554356772447a3638786a65683845644c7a4a552f70314375323135304669784256724a2b46394f416f6650393870476a56304d515858307168592b5269673432346f4d4e385a2b516e496b4a4f4933544c337a454f56386b4e776a35467a425762733058626831797774527a32744d4632714f3b4f61376179534b59386c435067584b4473784f695a4c7245587776756f6a517379614b4539596e4830667762754b66306278456a7764306361316f77524878516e556938366334334e51564f344249352f392f38644b5177766a48666b695a58356a4e3478544e33704d683750653758484e6241536d624138774c556b71496754556768785a72514751556e4a4e61464c6c4c685275445a334e49707a46644e4f57513d3b6b6a634d546659547255734f586932734364494d6453764434754a7a7a4f614979445a6c44534679414b536368584a6e56706535615945594962685543336e6d7773396133587770556958514a6d6379674b50432b70445a6c2f7770654f6b463832574c497863586549544d46504a736b4b47785162796c364d49646b334576514d544d53634462496245446d5536676f756a7174694e7449643959376f665a434958666659436f496e766f653861663b7474436b75536b6c4e4c64514b533235744a3269543737444850737338546c4e7435575a4d5775374269374f6753757150436c5352655442763466473373515876436e70774e7a594161744d746e3530514a5051366d2b556f5a4c41446b6555745842564d367472766857753276574d446879597266325271634c784a624c6d50357270566d4734725265324d646a30557a416d505530462f64636d38706745636451616d546f5a53513d3d3b617554636f535353704343706658456f6b745955486c54557248385755594a3961304f62544d73556f6846464463332f4d5069324d70596a347a7178504a672b53334246766768524c394f34764f656f3152724d435a674d4c5835392b6a66553432753045504d4d4756702f68614935386d5a66356f747730697249426a6a3242553032496163556e415a2f48534e65474f575574527732474f5653514e4b61484e3774666a71527152564749595a3537773d3d3b")
                .sign("allow unveil slide steak glimpse long hurt trend acid stereo equip clump")
                .transaction;

        payload.add(transaction.toHashMap());
        LinkedTreeMap<String, Object> postResponse = connection.api().transactions.create(payload);
        System.out.println(postResponse);
    }
}
