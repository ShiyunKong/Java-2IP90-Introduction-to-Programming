package nl.tue.assignments.hitting_shapes;

import java.util.Scanner;

/**
 * Detects if a point hits any of two circles.
 * 
 * Usage:
 * To use this program, 
 * provide eight floating-point numbers separated by spaces as input when prompted. 
 * The program will determine whether the given point hits either or both of the two circles 
 * and provide the corresponding output message.
 *
 * TODO: Documentation
 * This documentation explains the functionality and usage of the provided Java code, 
 * which is responsible for performing hit detection between two circles 
 * and a point in a 2D Cartesian coordinate system. 
 * The program determines whether the point hits either of the two circles, 
 * both circles, or none of them.
 * Overview
 * The code is divided into a single class named HitDetection. 
 * It contains two main methods: 
 * countSubstrings(String input) and run(). 
 * The main() method is the entry point of the program.
 * countSubstrings(String input)
 * This method is responsible for counting the number of substrings that can be generated 
 * from a given input string. 
 * It generates all possible substrings using simple logic that can pass cyclomatic complexity test.
 * Each substring is printed (optional), and the total count of substrings is returned.
 * Parameters
 *     input (String): The input string from which substrings are generated.
 * Method Implementation
 *     Initialize an integer variable totalCount to keep track of the total number of substrings.
 *     Use a nested loop structure:
 *         The outer loop iterates through the starting index of the substring, denoted by start.
 *         The inner loop iterates through the ending index of the substring, denoted by end.
 *     Extract a substring from start to end using the substring() method.
 *         Print each generated substring (optional).
 *         Increment the totalCount for each valid substring.
 *     Return the totalCount.
 * run()
 * The run() method is the main execution method of the program. 
 * It reads eight floating-point numbers from the standard input (console) 
 * and performs hit detection between two circles and a point.
 * Method Implementation
 *     Declare and initialize variables for various input values, 
 * including the coordinates of two circle centers (xCenter1, yCenter1, xCenter2, yCenter2), 
 * the radii of the circles (radius1, radius2), and the coordinates of the point (xPoint, yPoint).
 *     Read the eight floating-point numbers from the console using a Scanner.
 *     Parse and assign the input values to their respective variables 
 * based on the order in which they are read.
 *     Check if either of the circle radii is negative. If so, 
 * output "input error" and terminate the program.
 *     Calculate the distances from the point to the centers of both circles 
 * using the distance formula.
 *     Determine whether the point is inside or on the border of each circle by 
 * comparing the calculated distances to the circle radii.
 *     Based on the hit detection results, output one of the following messages:
 *         "The point hits both circles" (if the point hits both circles).
 *         "The point hits the first circle" (if the point hits the first circle only).
 *         "The point hits the second circle" (if the point hits the second circle only).
 *         "The point does not hit either circle" (if the point does not hit any circle).
 * Main Method
 * The main(String[] args) method serves as the entry point of the program. 
 * It creates an instance of the HitDetection class 
 * and invokes its run() method to execute the hit detection logic.
 * Usage
 * To use this program, provide eight floating-point numbers separated 
 * by spaces as input when prompted. 
 * The program will determine whether the given point hits either or both of the two circles 
 * and provide the corresponding output message.
 * Output
 * The program outputs one of the following messages:
 *     "The point hits both circles"
 *     "The point hits the first circle"
 *     "The point hits the second circle"
 *     "The point does not hit either circle"
 *     "input error" (if either circle radius is negative).
 * Note
 *     The code includes optional comments for clarification.
 *     The countSubstrings() method is included in the code 
 * but is not directly related to the hit detection functionality 
 * and may be used for other purposes.
 * END TODO
 * 
 * @author Shiyun Kong
 * @ID <1920874>
 * @author Xiuqi Shi
 * @ID <1935526>
 * 
 */

class HitDetection {
    /**
    * Counts the total number of substrings that can be generated from the input string.
    *
    * <p>The method iterates through the characters in the input string and generates
    * all possible substrings starting from each character. Each substring is counted,
    * and the total count of substrings is returned as the result.
    *
    * @param input The input string from which substrings are generated.
    * @return The total number of substrings that can be generated from the input string.
    */
    public static int countSubstrings(String input) {
        int totalCount = 0;

        // Outer loop iterates through the starting index of the substring
        for (int start = 0; start < input.length(); start++) {
            // Inner loop iterates through the ending index of the substring
            for (int end = start + 1; end <= input.length(); end++) {
                // Extract the substring from start to end
                String substring = input.substring(start, end);
                System.out.println(substring); // Optional: Print each substring
                totalCount++;
            }
        }
        return totalCount;
    }

    /**
    * Executes the hit detection program for two circles 
    * and a point in a 2D Cartesian coordinate system.
    *
    * <p>The method reads eight floating-point numbers 
    * from the standard input and performs hit detection
    * to determine which of two circles, if any, 
    * is hit by the given point. It calculates the distances
    * from the point to the centers of both circles 
    * and checks if the point is inside or on the border
    * of the circles. The program outputs the result accordingly.
    *
    * <p>Input format: Eight space-separated floating-point numbers representing the following:
    * 1. x-coordinate of the center of the first circle
    * 2. y-coordinate of the center of the first circle
    * 3. Radius of the first circle
    * 4. x-coordinate of the center of the second circle
    * 5. y-coordinate of the center of the second circle
    * 6. Radius of the second circle
    * 7. x-coordinate of the point
    * 8. y-coordinate of the point
    *
    * <p>Output format:
    * - "The point hits both circles" (if the point hits both circles)
    * - "The point hits the first circle" (if the point hits the first circle only)
    * - "The point hits the second circle" (if the point hits the second circle only)
    * - "The point does not hit either circle" (if the point does not hit any circle)
    * - "input error" (if either circle has a negative radius)
    */
    void run() {
        // TODO: HitDetection
        // Your program reads eight floating point numbers on input.
        Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        scanner.close();
        String[] words = input.split(" ");
        // The first two numbers represent the center of the first circle,
        // first its x-coordinate and then its y-coordinate.
        final double xCenter1 = Double.parseDouble(words[0]);
        final double yCenter1 = Double.parseDouble(words[1]);
        // The third number represents this circle’s radius.
        final double radius1 = Double.parseDouble(words[2]);
        // The next three numbers represent the second circle in exactly the same fashion.
        final double xCenter2 = Double.parseDouble(words[3]);
        final double yCenter2 = Double.parseDouble(words[4]);
        final double radius2 = Double.parseDouble(words[5]);
        // Finally, the last two numbers represent the point.
        final double xPoint = Double.parseDouble(words[6]);
        final double yPoint = Double.parseDouble(words[7]);
        // Finally, when either circle has a negative radius, the program outputs:
        if (radius1 < 0 || radius2 < 0) {
            System.out.println("input error");
            return;
        }
        // Given two circles and a point in a 2D Cartesian coordinate system,
        // write a program to detect which of these circles is hit by that point.
        final double xDistanceFromCenter1 = xPoint - xCenter1;
        final double yDistanceFromCenter1 = yPoint - yCenter1;
        final double xDistanceFromCenter2 = xPoint - xCenter2;
        final double yDistanceFromCenter2 = yPoint - yCenter2;
        final double distanceFromCenter1 = Math.sqrt(xDistanceFromCenter1 * xDistanceFromCenter1
                + yDistanceFromCenter1 * yDistanceFromCenter1);
        final double distanceFromCenter2 = Math.sqrt(xDistanceFromCenter2 * xDistanceFromCenter2
                + yDistanceFromCenter2 * yDistanceFromCenter2);
        // We say that a point hits a shape if that point is inside the shape.
        // If a point is on the border of the shape, that also counts as a hit.
        final boolean hit1 = distanceFromCenter1 <= radius1;
        final boolean hit2 = distanceFromCenter2 <= radius2;

        String[] hitMessages = {
            // When the point does not hit any of the two circles, the program outputs:
            "The point does not hit either circle",
            // When the point hits just a single circle, depending on which of the circles,
            // the program outputs:
            "The point hits the first circle",
            "The point hits the second circle",
            // When the point hits both circles, the program outputs:
            "The point hits both circles"
        };

        int hitIndex = (hit1 ? 1 : 0) + (hit2 ? 2 : 0);

        System.out.println(hitMessages[hitIndex]);
        // END TODO

    }

    public static void main(String[] args) {
        new HitDetection().run();
    }
}
