package com.luczarnik.TextConversion;

/** Hello world! */
public class App {
  public static void main(String[] args) {
    if (args.length != 3) {
      System.err.println(
          "Invalid number of arguments. Use <string> <begin Of substring> <end of substring>"
              + " *inclusive*");
      System.exit(1);
    }

    int beginOfSubstring = 0, endOfSubstring = 0;
    try {
      beginOfSubstring = Integer.parseInt(args[1]);
      endOfSubstring = Integer.parseInt(args[2]);
    } catch (NumberFormatException e) {
      System.err.println("Improper arguments, boundaries of range must be integers !");
      System.exit(2);
    }

    if ((beginOfSubstring < 0 && endOfSubstring < 0)
        || (beginOfSubstring >= args[0].length() && endOfSubstring >= args[0].length())) {
      System.err.println("Substring boundaries outside provided string.");
      System.exit(3);
    }

    boolean reversed = false;
    if (beginOfSubstring > endOfSubstring) {
      int temp = beginOfSubstring;
      beginOfSubstring = endOfSubstring;
      endOfSubstring = temp;
      reversed = true;
    }

    if (beginOfSubstring < 0) beginOfSubstring = 0;
    if (endOfSubstring >= args[0].length()) endOfSubstring = args[0].length();
    endOfSubstring++;

    String substring = args[0].substring(beginOfSubstring, endOfSubstring);
    if (reversed) substring = new StringBuilder(substring).reverse().toString();

    System.out.println(substring);
    System.exit(0);
  }
}
