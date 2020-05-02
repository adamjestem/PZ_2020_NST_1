package org.budowa.services;

public abstract class PasswordEncryptor {

    public static PasswordEncryptor inject() {
        return new Md5PasswordEncryptor();
    }

    public abstract String encryptPassword(String password);
}
