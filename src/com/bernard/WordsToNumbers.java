package com.bernard;

import java.util.HashMap;
import java.util.Map;

public class WordsToNumbers {
    public String inputWord;
    public String outputWord;
    public Map<Character, Integer> word = new HashMap<Character, Integer>();


    public Integer[] output(String outputWord) {
        Integer[] outputInNumber = new Integer[outputWord.length()];
        for (int i = 0; i < outputWord.length(); i++) {
            outputWord.toUpperCase();
            word.put(outputWord.charAt(i), i + 1);
            outputInNumber[i] = i + 1;
        }
        return outputInNumber;
    }

    public Integer[] input(String inputWord) {
        Integer[] inputInNumber = new Integer[inputWord.length()];
        for (int j = 0; j < inputWord.length(); j++) {
            inputWord.toUpperCase();
            inputInNumber[j] = word.get(inputWord.charAt(j));
        }
        return inputInNumber;
    }
}
