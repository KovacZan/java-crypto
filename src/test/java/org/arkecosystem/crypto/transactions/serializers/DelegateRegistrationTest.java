package org.arkecosystem.crypto.transactions.serializers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.crypto.encoding.Hex;
import org.arkecosystem.crypto.transactions.Deserializer;
import org.arkecosystem.crypto.transactions.FixtureLoader;
import org.arkecosystem.crypto.transactions.Serializer;
import org.arkecosystem.crypto.transactions.types.Transaction;
import org.junit.jupiter.api.Test;

class DelegateRegistrationTest {
    @Test
    void passphrase() {
        LinkedTreeMap<String, Object> fixture =
                FixtureLoader.load("transactions/v2-ecdsa/delegate-registration-sign");
        Transaction transaction =
                new Deserializer(fixture.get("serialized").toString()).deserialize();

        String actual = Hex.encode(Serializer.serialize(transaction));

        assertEquals(fixture.get("serialized").toString(), actual);
    }

    @Test
    void secondPassphrase() {
        LinkedTreeMap<String, Object> fixture =
                FixtureLoader.load("transactions/v2-ecdsa/delegate-registration-secondSign");
        Transaction transaction =
                new Deserializer(fixture.get("serialized").toString()).deserialize();

        String actual = Hex.encode(Serializer.serialize(transaction));

        assertEquals(fixture.get("serialized").toString(), actual);
    }
}
