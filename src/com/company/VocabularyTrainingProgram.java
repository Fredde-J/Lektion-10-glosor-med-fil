package com.company;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VocabularyTrainingProgram {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Word> wordsArray = new ArrayList<>();
    String menuChoice = "";

    public void vocabularyTrainingProgram(){
        while(!menuChoice.equals("5")){
            showMainMenu();
            menuChoice = scanner.next();
            switch(menuChoice){
                case "1":
                    addWordsFromFile();
                    break;
                case "2":
                    Collections.shuffle(wordsArray);
                    break;
                case "3":
                    takeTheTest();
                    break;
                case "4":
                    showAllWords();
                    break;
                case "5":
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Not a valid choice, please try again");
                    break;
            }
        }
    }
    public void showMainMenu(){
        System.out.println("1. Add words");
        System.out.println("2. Shuffle the words in the list");
        System.out.println("3. Take the test");
        System.out.println("4. Show all the words");
        System.out.println("5. Exit");
    }
    public void addWordsFromFile() {
        String fileName = "wordInput.txt";
        try {
            List<String> wordFromFile = Files.readAllLines(Paths.get(fileName));
            for (String row :wordFromFile) {
                String[] words =row.split(";");
                wordsArray.add(new Word(words[0],words[1]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Words have been added");

    }



    public void showAllWords(){
        for(Word word : wordsArray){
            System.out.println(word.getSwedishWord());
            System.out.println(word.getEnglishWord());
        }

        }

    public void takeTheTest() {
        int playerPoints = 0;
        for (Word w : wordsArray) {
            System.out.println("What is the english word for " + w.getSwedishWord() + " ?");
            String playerGuess = scanner.next();
            if(w.verifyAnswer(playerGuess)){
                System.out.println(w.getEnglishWord()+" is correct!");
                ++playerPoints;
            }
            else{
                System.out.println(playerGuess+" is wrong, the correct answer is " +w.getEnglishWord());
                System.out.println("Your score is : "+playerPoints);
                break;
            }
        }
        System.out.println("test");
    }
}

