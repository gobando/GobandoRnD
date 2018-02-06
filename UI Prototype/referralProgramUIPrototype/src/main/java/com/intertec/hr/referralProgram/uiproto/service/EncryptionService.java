package com.intertec.hr.referralProgram.uiproto.service;

/**
 * Created by gerardoobando.arce on 2/21/2017.
 */

public interface EncryptionService {
    String encryptString(String input);
    boolean checkPassword(String plainPassword, String encryptedPassword);
}
