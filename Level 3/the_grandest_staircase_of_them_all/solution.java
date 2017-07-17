package com.google.challenges;

public class Answer {

  static int[][] mem = new int[202][202];

  public static int answer(int n) {
    return helper(1, n) - 1;
  }

  public static int helper(int height, int left) {
    if (mem[height][left] != 0) {
      return mem[height][left];
    }
    if (left == 0) {
      return 1;
    }
    if (left < height) {
      return 0;
    }

    int value = helper(height + 1, left - height) + helper(height + 1, left);
    mem[height][left] = value;
    return value;
  }
}