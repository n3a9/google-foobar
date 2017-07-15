package com.google.challenges;

public class Answer {

  public static int answer(String s) {
    char[] charr = s.toCharArray();
    int counter = 0, sum = 0;
    
    for (char ch : charr) {
      if (ch == '>') {
        counter++;
      } else if (ch == '<') {
        sum = sum + counter;
      }
    }
    return sum * 2; // 2 handshakes for each interaction
  }
}