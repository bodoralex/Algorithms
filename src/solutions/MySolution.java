package solutions;

import java.util.Arrays;

public class MySolution implements Solution {

    private float number;

    @Override
    public String reverseString(String word) {
        //return new StringBuilder(word).reverse().toString();
        StringBuilder reversed = new StringBuilder();
        char[] chars = word.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed.append(chars[i]);
        }
        return reversed.toString();
    }

    @Override
    public long factorialize(int number) {
        long result = 1;
        for (int i = 1; i < number + 1; i++) {
            result *= i;
        }
        return result;
    }

    @Override
    public boolean palindrome(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Character character : word.toCharArray()) {
            if (Character.isAlphabetic(character) || Character.isDigit(character)) {
                stringBuilder.append(Character.toLowerCase(character));
            }
        }
        String result = stringBuilder.toString();
        return result.equals(reverseString(result));
    }

    @Override
    public int findLongestWord(String word) {
        String[] strings = word.split(" ");
        int max = strings[0].length();
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].length() > max) max = strings[i].length();
        }
        return max;
    }

    @Override
    public String titleCase(String string) {
        String[] strings = string.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : strings) {
            stringBuilder.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public int[] largestOfFour(int[][] numbers) {
        int[] largestNumbers = new int[4];

        for (int i = 0; i < numbers.length; i++) {
            int[] subArray = numbers[i];
            int max = subArray[0];
            for (int number : subArray) {
                if (number > max) {
                    max = number;
                }
                largestNumbers[i] = max;
            }
        }
        return largestNumbers;
    }

    @Override
    public boolean confirmEnding(String word, String end) {
        return word.substring(word.length() - end.length()).equals(end);
    }

    @Override
    public String repeatStringNumTimes(String word, int counter) {
        String result = "";
        for (int i = 0; i < counter; i++) {
            result += word;
        }
        return result;
    }

    @Override
    public String truncateString(String word, int counter) {
        String result;
        if (word.length() <= counter) {
            result = word;
        } else if (counter >= 3) {
            result = word.substring(0, counter - 3) + "...";
        } else {
            result = word.substring(0, counter) + "...";
        }
        return result;
    }

    @Override
    public Object[][] chunkArrayInGroups(Object[] numbers, int counter) {
        Object[][] result = new Object[0][];
        Object[] temp = new Object[0];
        for (Object o : numbers) {
            if (temp.length >= counter) {
                result = addArrayToArray(result, temp);
                temp = new Object[0];
            }
            temp = addObjectToArray(temp, o);
        }
        if (temp.length != 0) result = addArrayToArray(result, temp);
        return result;

    }

    private Object[] addObjectToArray(Object[] array, Object toAdd) {
        Object[] newArray = new Object[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = toAdd;
        return newArray;
    }

    private Object[][] addArrayToArray(Object[][] array, Object[] toAdd) {
        Object[][] newArray = new Object[array.length + 1][];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = toAdd;
        return newArray;
    }

    @Override
    public Object[] slasher(Object[] numbers, int counter) {

        int remainder = numbers.length - counter;
        Object[] array = new Object[remainder < 0 ? 0 : remainder];
        for (int i = 0; i < array.length; i++) {
            array[i] = numbers[i + counter];
        }
        return array;
    }

    @Override
    public Object[] destroyer(Object[] numbers, int[]... remove) {
        Object[] result = new Object[0];
        for (Object item : numbers) {
            boolean toContinue = false;
            for (Object removable : remove[0]) {
                if (item.equals(removable)) {
                    toContinue = true;
                    break;
                }
            }
            if (toContinue) continue;
            result = addObjectToArray(result, item);
        }
        return result;
    }

    @Override
    public int getIndexToIns(Object[] numbers, float number) {
        int numbersLessThan = 0;
        for (Object o : numbers) {
            if((int)o < number) numbersLessThan++;
        }
        return numbersLessThan;
    }

    @Override
    public String rot13(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(Character.isAlphabetic(chars[i])){
                chars[i] += 13;
                if(chars[i] > 90) chars[i] -= 26;
            }
        }
        return new String(chars);
    }
}