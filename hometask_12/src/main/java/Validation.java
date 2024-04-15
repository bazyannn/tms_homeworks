public class Validation {

    private static final String PATTERNLog = "^[a-zA-Z_0-9]{0,20}$";
    private static final String PATTERNPass = "^[a-zA-Z0-9]{0,20}$";

    public void Valid(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {

        if (!login.matches(PATTERNLog)) {
            throw new WrongLoginException("Invalid Login");
        } else if (!password.matches(PATTERNPass) | !password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }
}

