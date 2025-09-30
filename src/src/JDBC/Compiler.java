package JDBC;

import java.util.Base64;

public class Compiler {
    public static String compileUsername(String username){
        username = Base64.getEncoder().encodeToString(username.getBytes());
        return username;
    }

    public static String compilePassword(String password){
        password = Base64.getEncoder().encodeToString(password.getBytes());
        return password;
    }

    public static String decompileUsername(String username){
        byte[] arrayBytesDecode = Base64.getDecoder().decode(username);
        return new String(arrayBytesDecode);
    }

    public static String decompilePassword(String password){
        byte[] arrayBytesDecode = Base64.getDecoder().decode(password);
        return new String(arrayBytesDecode);
    }
}
