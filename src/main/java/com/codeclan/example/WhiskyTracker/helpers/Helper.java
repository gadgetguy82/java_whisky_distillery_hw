package com.codeclan.example.WhiskyTracker.helpers;

public class Helper {
  public static String capitalise(String string) {
    String[] wordArray = string.toLowerCase().split(" ");
    String[] capitalisedWords = new String[wordArray.length];
    for(int i = 0; i < wordArray.length; i++) {
      String firstLetter = wordArray[i].substring(0, 1).toUpperCase();
      capitalisedWords[i] = firstLetter + wordArray[i].substring(1);
    }
    return String.join(" ", capitalisedWords);
  }
}
