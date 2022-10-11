/*
* This program manipulates strings with
* characters and numbers.
*
* @author  Daria Bernice Calitis
* @version 11.0.16
* @since   2022-10-10
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This is Main class.
 */
final class Main {
    /**
     * Prevent instantiation.
     * Throw an exception IllegalStateException.
     * if this ever is called
     *
     * @throws IllegalStateException
     *
     */
    private Main() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * The starting main() function.
     *
     * @param args No args will be used
     */
    public static void main(String[] args) {
        // Input.
        final Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter a string of characters and numbers: ");
        final String inputString = scanner.nextLine();

        final String[] textArr = inputString.split("");
        final List<String> text = new ArrayList<String>();
        Collections.addAll(text, textArr);

        final ArrayList<String> newText = new ArrayList<String>();

        for (int count = 0; count < text.size(); count++) {
            final String item = text.get(count);
            String newString = "";

            // Checks if the item is not a number or the last item of the array.
            if (!(isNumeric(item))) {
                if (count - 1 != -1) {
                    // Checks if the previous character is not a number.
                    if (!(isNumeric(text.get(count - 1)))) {
                        // Pushes the original character into the array.
                        newString = item;
                        newText.add(newString);
                    }
                } else {
                    newString = item;
                    newText.add(item);
                }
            } else {
                // Checks if this item is the last one.
                if (count + 1 < text.size()) {
                    // This replaces the digit with
                    // a number of characters or numbers.
                    final int itemInt = Integer.parseInt(item);
                    for (int count2 = 0; count2 < itemInt; count2++) {
                        newString = newString.concat(text.get(count + 1));
                    }
                    // Skips to the item after the next one.
                    if (!isNumeric(text.get(count + 1))) {
                        text.remove(count);
                    }
                }

                newText.add(newString);
            }
        }

        // Output - joins the array and prints it out.
        final String newTextString = String.join("", newText);
        System.out.println(newTextString);

        System.out.println("\nDone.");
    }

    /**
     * The isNumeric() function.
     *
     * <p>Checks if the string is numerical.
     * <p/>
     *
     * @param str String input
     * @return a boolean
     */
    private static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9.]+");
    }
}
