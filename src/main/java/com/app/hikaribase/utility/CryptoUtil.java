package com.app.hikaribase.utility;

import com.app.hikaribase.config.SecretsConfig;
import lombok.RequiredArgsConstructor;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class CryptoUtil {

    private final SecretsConfig secretsConfig;
    private final AES256TextEncryptor encryptor = new AES256TextEncryptor();

    @PostConstruct
    public void init() {
        encryptor.setPassword(secretsConfig.getKey());
    }

    public String encrypt(String plaintText) {
        return encryptor.encrypt(plaintText);
    }
}
