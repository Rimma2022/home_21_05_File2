import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Corporation {
    public static ArrayList<Employee> employeesList = new ArrayList<>();
    public static Employees employees = new Employees(employeesList);
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static String str;

    public static void write () {
        try (FileOutputStream fos1 = new FileOutputStream("file.txt");
             ObjectOutputStream objOutStr = new ObjectOutputStream(fos1)){
            objOutStr.writeObject(employees);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeNew (String strNew, String str2) {
        File file1 = new File(strNew);
        byte [] mass1 = str2.getBytes(StandardCharsets.UTF_8);
        FileOutputStream outputStream1 = null;
        try {
            outputStream1 = new FileOutputStream(file1);
            outputStream1.write(mass1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read () {
        try (FileInputStream fis1 = new FileInputStream(str);
             ObjectInputStream objIntStr = new ObjectInputStream(fis1)){
            Employees result = (Employees) objIntStr.readObject();
            System.out.println(result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void add () throws IOException {
        System.out.println("Введите фамилию сотрудника: ");
        String surname = bufferedReader.readLine();
        System.out.println("Введите имя сотрудника: ");
        String name = bufferedReader.readLine();
        System.out.println("Введите возраст сотрудника: ");
        String ageString = bufferedReader.readLine();
        Integer age = Integer.parseInt(ageString);
        System.out.println("Введите должность сотрудника: ");
        String position = bufferedReader.readLine();
        Employee emN = new Employee(surname, name, age, position);
        employeesList.add(emN);
        Employees employees = new Employees(employeesList);
        write();
        System.out.println("Сотрудник добавлен");
        read();
    }

    public static void remove () throws IOException {
        System.out.println("Введите фамилию сотрудника, которого нужно удалить: ");
        String surname = bufferedReader.readLine();
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).getSurname().equals(surname)) {
                employeesList.remove(i);
            }
        }
        write();
        System.out.println("Сотрудник удален");
        read();
    }

    public static void edit () throws IOException {
        System.out.println("Введите фамилию сотрудника, которого нужно редактировать: ");
        String surname = bufferedReader.readLine();
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).getSurname().equals(surname)) {
                System.out.println("Введите новый возраст сотрудника: ");
                String ageString = bufferedReader.readLine();
                Integer age = Integer.parseInt(ageString);
                Employee emN = new Employee(surname, employeesList.get(i).getName(), age, employeesList.get(i).getPosition());
                employeesList.set(i, emN);
            }
        }
        System.out.println("Возраст изменен");
        write();
        read();
    }

    public static void searchBySurname () throws IOException {
        System.out.println("Введите фамилию сотрудника, которого нужно найти: ");
        String surname = bufferedReader.readLine();
        String str2 = null;
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).getSurname().equals(surname)) {
                str2 = String.valueOf(employeesList.get(i));
            }
        }
        System.out.println(str2);
        System.out.println("Введите путь файла, куда сохранить информацию: ");
        String strNew = bufferedReader.readLine();
        writeNew(strNew, str2);
        System.out.println("Файл создан с данной информацией");
    }

    public static void searchByAge () throws IOException {
        System.out.println("Введите возраст, по которому нужно отфильтровать сотрудников: ");
        String ageString = bufferedReader.readLine();
        Integer age = Integer.parseInt(ageString);
        String str2 = "";
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).getAge() == age) {
                str2 += String.valueOf(employeesList.get(i));
            }
        }
        System.out.println(str2);
        System.out.println("Введите путь файла, куда сохранить информацию: ");
        String strNew = bufferedReader.readLine();
        writeNew(strNew, str2);
        System.out.println("Файл создан с данной информацией");
    }

    public static void searchByLetter () throws IOException {
        System.out.println("Введите букву, по которой нужно отфильтровать фамилии сотрудников: ");
        String letter = bufferedReader.readLine();
        String str2 = "";
        for (int i = 0; i < employeesList.size(); i++) {
            String surname = employeesList.get(i).getSurname();
            if (surname.indexOf(letter) == 0) {
                str2 += String.valueOf(employeesList.get(i));
            }
        }
        System.out.println(str2);
        System.out.println("Введите путь файла, куда сохранить информацию: ");
        String strNew = bufferedReader.readLine();
        writeNew(strNew, str2);
        System.out.println("Файл создан с данной информацией");
    }

    public static void main(String[] args) throws IOException {
        /**
         * Задание 5
         * Напишите информационную систему "Корпорация".
         * Программа должна обеспечивать:
         * ■ ввод данных;
         * ■ редактирование данных сотрудника корпорации;
         * ■ удаление сотрудника корпорации;
         * ■ поиск сотрудника корпорации по фамилии;
         * ■ вывод информации обо всех сотрудниках, указанного возраста, или фамилия которых начинается на
         * указанную букву.
         * Организуйте возможность сохранения найденной
         * информации в файл.
         * Также весь список сотрудников корпорации сохраняется
         * в файл (при выходе из программы автоматически, в процессе исполнения программы по команде пользователя).
         * При старте программы происходит загрузка списка
         * сотрудников корпорации из указанного пользователем
         * файла.
         */
        Employee em1 = new Employee("Иванов", "Иван", 55, "Сторож");
        Employee em2 = new Employee("Клименкова", "Римма", 29, "Экономист");
        Employee em3 = new Employee("Сугак", "Михаил", 37, "Менеджер");
        Employee em4 = new Employee("Ромская", "Ольга", 37, "Бухгалер");
        Employee em5 = new Employee("Клименков", "Родион", 25, "Программист");
        employeesList.add(em1);
        employeesList.add(em2);
        employeesList.add(em3);
        employeesList.add(em4);
        employeesList.add(em5);
        write();
        System.out.println("Введите путь к файлу: ");
        str = bufferedReader.readLine();
        read();
        Integer x;
        do {
            System.out.println("0. Выход;\n1. Добавить сотрудника;\n2. Редактировать возраст сотрудника;\n3. Удалить сотрудника;\n4. Поиск сотрудника по фамилии");
            System.out.println("5. Вывод информации обо всех сотрудниках, указанного возраста;\n6. Вывод информации обо всех сотрудниках, фамилия, которых начинается на указанную букву");
            String X = bufferedReader.readLine();
            x = Integer.parseInt(X);
            switch (x) {
                case 1: {
                    add();
                    break;
                }
                case 2: {
                    edit();
                    break;
                }
                case 3: {
                    remove();
                    break;
                }
                case 4: {
                    searchBySurname();
                    break;
                }
                case 5: {
                    searchByAge();
                    break;
                }
                case 6: {
                    searchByLetter();
                    break;
                }
            }

        } while (x != 0);
    }
}
// E:\JAVA IDEA\home_21_05_File2\file.txt
// E:\JAVA IDEA\home_21_05_File2\fileNew1.txt