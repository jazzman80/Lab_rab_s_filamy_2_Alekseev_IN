//Программа сохраняет единственную текстовую заметку
//Перед началом работы пользователь может выбрать,
//написать новый текст (и стереть сохранённый)
//или дописать новый текст после сохранённого

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userChoice;

        do {
            System.out.println("Текстовый редактор");
            System.out.println("Стереть сохранённый текст?");
            System.out.println("y - стереть/n - дополнить");
            userChoice = scanner.nextLine();
            if(!userChoice.equals("y") && !userChoice.equals("n")) System.out.println("Введите корректный ответ");
        }while (!userChoice.equals("y") && !userChoice.equals("n"));

        if(userChoice.equals("y")){

            System.out.println("Введите новый текст");
            String userText = scanner.nextLine();

            try (FileWriter fileWriter = new FileWriter("text_file", false)) {
                fileWriter.write(userText);
                // fileWriter.flush();
            }
            catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        } else {
            StringBuilder savedText = new StringBuilder();
            System.out.println("Дополните текст");

            try (FileReader fileReader = new FileReader("text_file")){
                int c;
                while ((c= fileReader.read())!=-1){
                    savedText.append((char) c);
                }
            }
            catch (Exception exception){
                System.out.println(exception.getMessage());
            }

            System.out.println(savedText);
            String userText = scanner.nextLine();

            try(FileWriter fileWriter = new FileWriter("text_file", true)){
                fileWriter.write("\n" + userText);
            }
            catch (Exception exception){
                System.out.println(exception.getMessage());
            }

        }

    }
}