import java.util.regex.Pattern;

public class Validation {

    public static boolean validService(String login, String password, String confirmPassword )
            throws WrongLoginException, WrongPasswordException {

        boolean isLogin = Pattern.matches("^[a-zA-Z_0-9]{0,20}$", login);
        boolean isPassword = Pattern.matches("^[a-zA-Z0-9]{0,20}$", password);

        if (!isLogin) {
            throw new WrongLoginException("Invalid Login");
        } else if (!isPassword | !password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        } return true;
    }
}

