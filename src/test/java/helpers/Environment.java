package helpers;

public class Environment {
    public static final String
        url = System.getProperty("url", null),
        jUserName = System.getProperty("j_user_name",  null),
        jPassword = System.getProperty("j_password", null);
}

