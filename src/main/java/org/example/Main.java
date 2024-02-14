package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> phoneBook = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду: \n1 - Добавить контакт в телефонную книгу,\n" + "2 - Удалить контакт,\n" + "3 - Удалить номер телефона контакта,\n" + "4 - Вывести номера телефонов контакта,\n" + "5 - Вывести телефонную книгу,\n" + "0 - Выйти из телефонной книги: ");
            String operation = sc.nextLine();
            switch (operation) {
                case "1":
                    addContact(phoneBook, sc);
                    break;
                case "2":
                    removeContakt(phoneBook, sc);
                    break;
                case "3":
                    removeNumber(phoneBook, sc);
                    break;
                case "4":
                    showNumbersContakt(phoneBook, sc);
                    break;
                case "5":
                    printPhoneBook(phoneBook);
                    break;
                case "0":
                    System.out.println("До встречи!");
                    System.exit(0);
                default:
                    System.out.println("Неверная команда. Введите команду снова:");
            }


        }

    }

    /**
     * @apiNote Добавляет контакт в телефонную книгу
     * @param pb - телефонная книга
     * @param scanner - ввод данных
     */
    public static void addContact(Map<String, ArrayList<String>> pb, Scanner scanner) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Ведите имя контакта: ");
        String name = scanner.nextLine().toLowerCase();
        System.out.println("Введите номер телефона: ");
        String number = scanner.nextLine();
        if (pb.containsKey(name)) {
            list = pb.get(name);
        }
        list.add(number);
        pb.put(name, list);
    }

    /**
     * @apiNote Удаляет контакт
     * @param pb - телефонная книга
     * @param scanner - ввод данных
     */
    public static void removeContakt(Map<String, ArrayList<String>> pb, Scanner scanner) {
        System.out.println("Ведите имя контакта: ");
        String name = scanner.nextLine().toLowerCase();
        if (pb.containsKey(name)) {
            pb.remove(name);
        } else {
            System.out.println("Такого контакта нет");
        }
    }

    /**
     * @apiNote Удаляет номер телефона контакта
     * @param pb - телефонная книга
     * @param scanner - ввод данных
     */
    public static void removeNumber(Map<String, ArrayList<String>> pb, Scanner scanner) {
        System.out.println("Ведите имя контакта: ");
        String name = scanner.nextLine().toLowerCase();
        System.out.println("Введите номер телефона: ");
        String number = scanner.nextLine();
        if (pb.containsKey(name)) {
            if (pb.get(name).contains(number)) {
                ArrayList<String> list = new ArrayList<>();
                list = pb.get(name);
                list.remove(list.indexOf(number));
                pb.put(name, list);
            }
        }
    }

    /**
     * @apiNote Выводит номера телефонов указанного контакта
     * @param pb - телефонная книга
     */
    public static void showNumbersContakt(Map<String, ArrayList<String>> pb, Scanner scanner) {
        System.out.println("Ведите имя контакта: ");
        String name = scanner.nextLine().toLowerCase();
        ArrayList<String> numbers = new ArrayList<>();
        numbers = pb.get(name);
        if (numbers.isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.println(numbers);
        }
    }


    /**
     * @apiNote Выводит содержимое телефонной книги
     * @param book - телефонная книга
     */
    public static void printPhoneBook(Map<String, ArrayList<String>> book) {
        List<Map.Entry<String, ArrayList<String>>> sortedEntries = new ArrayList<>(book.entrySet());

        // Сортируем записи по убыванию числа телефонов
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Выводим отсортированные записи
        for (Map.Entry<String, ArrayList<String>> entry : sortedEntries) {
            String name = entry.getKey();
            List<String> numbers = entry.getValue();
            System.out.println(name + ":");
            for (String number : numbers) {
                System.out.println(number);
            }
            System.out.println();
        }
    }
}