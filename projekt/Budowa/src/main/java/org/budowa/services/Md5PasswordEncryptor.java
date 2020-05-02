package org.budowa.services;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5PasswordEncryptor extends PasswordEncryptor {
    public String encryptPassword(String password) {
        return DigestUtils.md5Hex(password);
    }
}
