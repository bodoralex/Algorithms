package solutions;

public interface Solution {
    String reverseString(String word);
    long factorialize(int number);
    boolean palindrome(String word);
    int findLongestWord(String word);
    String titleCase(String word);
    int[] largestOfFour(int[][] numbers);
    boolean confirmEnding(String word,String end);
    String repeatStringNumTimes(String word,int counter);
    String truncateString(String word,int counter);
    Object[][] chunkArrayInGroups(Object[] numbers,int counter);
    Object[] slasher(Object[] numbers,int counter);
    Object[] destroyer(Object[] numbers,int[]... remove);
    int getIndexToIns(Object[] numbers,float number);
    String rot13(String word);
}
