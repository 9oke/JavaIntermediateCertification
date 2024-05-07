import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создание телефонной книги.
        Map<String, Set<String>> phoneBook = new HashMap<>();

        // Добавление записей в телефонную книгу.
        addContact(phoneBook, "Иван Иванов", "+79111234567");
        addContact(phoneBook, "Пётр Петров", "+79997659011");
        addContact(phoneBook, "Иван Иванов", "+78990114567");
        addContact(phoneBook, "Николай Николаев", "+79063215679");
        
        // Вывод отсортированной телефонной книги.
        printPhoneBook(phoneBook);
    }

    // Добавление контакта в телефонную книгу. С учётом дублирования номеров телефона.
    private static void addContact(Map<String, Set<String>> phoneBook, String name, String phoneNumber) {
        if ( phoneBook.containsKey(name) ) {
            phoneBook.get(name).add(phoneNumber);
        } else {
            Set<String> phoneNumbers = new HashSet<String>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }
    // Вывод отсортированной телефонной книги
    public static void printPhoneBook(Map<String, Set<String>> phoneBook) {
        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}