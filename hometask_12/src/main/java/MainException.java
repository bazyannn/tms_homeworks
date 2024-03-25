import java.util.Scanner;
/*
Задача 1:
        Создать класс, в котором будет статический метод. Этот метод принимает на вход три
параметра: login, password, confirmPassword. Все поля имеют тип данных String. Длина
login должна быть меньше 20 символов и не должен содержать пробелы. Если login не
соответствует этим требованиям, необходимо выбросить WrongLoginException. Длина
password должна быть меньше 20 символов, не должен содержать пробелом и должен содержать хотя бы одну цифру.
Также password и confirmPassword должны быть равны.
Если password не соответствует этим требованиям, необходимо выбросить
WrongPasswordException. WrongPasswordException и WrongLoginException -
пользовательские классы исключения с двумя конструкторами – один по умолчанию,
второй принимает сообщение исключения и передает его в конструктор класса Exception.
Метод возвращает true, если значения верны, false в противном случае.
*/
public class MainException {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your login using numbers, letters and the \"_\" symbol, less than 20 characters");

        String login = scanner.nextLine();

        System.out.println("enter the password using letters and at least 1 number, less than 20 characters");

        String password = scanner.nextLine();

        System.out.println("Confirm the password");

        String confirmPassword = scanner.nextLine();

        try {
            System.out.println(Validation.validService(login,password,confirmPassword));
        } catch (WrongLoginException exc) {
            boolean isLogin = false;
            System.out.println(isLogin);
            System.out.println(exc.getMessage());
            System.out.println("Enter valid Login");
        } catch (WrongPasswordException e) {
            boolean isPassword = false;
            System.out.println(isPassword);
            System.out.println("invalid Password\n" + "Enter valid Password");
            System.out.println(e.getMessage());
        }

    }
}

