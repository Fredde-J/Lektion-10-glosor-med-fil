package com.company;

public class Word {
    private String swedishWord;
    private String englishWord;

    public Word(String swedishWord, String englishWord) {
        this.swedishWord = swedishWord;
        this.englishWord = englishWord;
    }


    public String getSwedishWord() {
        return swedishWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void test(String swedishWord, String englishWord) {
        System.out.println("Swedish word : " + swedishWord + "     (/)     " + "English word : " + englishWord);
    }

    public boolean verifyAnswer(String wordGuess) {
        return (englishWord.equals(wordGuess));
    }
}


