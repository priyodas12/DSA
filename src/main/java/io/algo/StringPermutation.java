package io.algo;

import java.util.Set;
import java.util.HashSet;

public class StringPermutation {

  public static Set<String> generatePermutations(String input) {
    Set<String> permutations = new HashSet<>();
    generatePermutationsHelper("", input, permutations);
    return permutations;
  }

  private static void generatePermutationsHelper(String prefix, String remaining, Set<String> permutations) {
    int n = remaining.length();
    if (n == 0) {
      permutations.add(prefix);
    } else {
      for (int i = 0; i < n; i++) {
        generatePermutationsHelper(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1, n), permutations);
      }
    }
  }

  public static void main(String[] args) {
    String input = "abc";
    Set<String> result = generatePermutations(input);
    System.out.println("Permutations of " + input + ": " + result);
  }
}

