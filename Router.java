import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Router {
   public static ArrayList<String> strings = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));

    public static void route() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice;
        do {
            System.out.println(" Здравствуйте! Выберите действие, которое хотите совершить:");
            System.out.println(" 1. Добавить пользователя - введите 1");
            System.out.println(" 2. Изменить пользователя - введите 2");
            System.out.println(" 3. Удалить пользователя - введите 3");
            System.out.println(" 4. Вывести список всех пользователей - введите 4");
            System.out.println(" 5. Выйти - введите 5");
            choice = reader.readLine();
        } while (!strings.contains(choice));

        switch (choice) {
            case "1":
                System.out.println("Введите имя ");
                String firstName = reader.readLine();
                System.out.println(" Введите фамилию ");
                String lastName = reader.readLine();
                break;
            case "2":
                System.out.println(" Введите Имя человека, Фамилию которого хотите ихменить");
                String editFirstName = reader.readLine();
                System.out.println(" Введите новую фамилию ");
                String editLastName = reader.readLine();
                break;
            case "3":
                System.out.println(" Что бы удалить пользователя введите имя");
                String deletionPerson = reader.readLine();
                break;
            case "4":
                System.out.println("Вывести список всех пользователей");
                break;
            case "5":
                System.exit(0);
                break;
        }
    }

}