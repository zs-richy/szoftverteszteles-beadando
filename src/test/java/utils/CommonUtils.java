package utils;

import java.util.UUID;

public class CommonUtils {

    public static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }
}
