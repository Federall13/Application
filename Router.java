import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Router {

    public static void route() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char choice, ignore;

        do {
            System.out.println(" Здравствуйте! Выберите действие, которое хотите совершить:");
            System.out.println(" 1. Добавить пользователя - введите 1");
            System.out.println(" 2. Изменить пользователя - введите 2");
            System.out.println(" 3. Удалить пользователя - введите 3");
            System.out.println(" 4. Вывести список всех пользователей - введите 4");
            System.out.println(" 5. Выйти - введите 5");

            choice = (char) reader.read();
            do {
                ignore = (char) reader.read();
            } while (ignore != '\n');
        } while (choice < '1' | choice > '5');

        switch (choice) {
            case '1':
                System.out.println("Введите имя ");
                String firstName = reader.readLine();
                System.out.println(" Введите фамилию ");
                String lastName = reader.readLine();
                break;
            case '2':
                System.out.println(" Введите Имя человека, Фамилию которого хотите ихменить");
                String editFirstName = reader.readLine();
                System.out.println(" Введите новую фамилию ");
                String editLastName = reader.readLine();
                break;
            case '3':
                System.out.println(" Что бы удалить пользователя введите имя");
                String deletionPerson = reader.readLine();
                break;
            case '4':
                System.out.println("Вывести список всех пользователей");
                break;
            case '5':
                System.exit(0);
                break;
            default:
                System.out.println(" Не верное число ");
        }
    }

}