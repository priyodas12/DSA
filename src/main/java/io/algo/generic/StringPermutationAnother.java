package io.algo.generic;

import java.util.LinkedHashSet;
import java.util.Set;

public class StringPermutationAnother {

  public static Set<String> generatePermutations(String input) {
    Set<String> permutations = new LinkedHashSet<>();
    generatePermutationsHelper(input.toCharArray(), 0, permutations);
    return permutations;
  }

  private static void generatePermutationsHelper(char[] chars, int index, Set<String> permutations) {

    //base condition
    if (index == chars.length - 1) {
      permutations.add(new String(chars));
    } else {
      for (int i = index; i < chars.length; i++) {
        swap(chars, index, i);
        generatePermutationsHelper(chars, index + 1, permutations);
        swap(chars, index, i); // Backtrack
      }
    }
  }

  private static void swap(char[] chars, int i, int j) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
  }

  public static void main(String[] args) {
    String input = "1234";
    Set<String>  result = generatePermutations(input);
    System.out.println("Permutations of " + input + ": " + result);
  }
}

