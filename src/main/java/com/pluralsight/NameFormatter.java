package com.pluralsight;

public class NameFormatter {


    private NameFormatter() {}

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        return (lastName.equalsIgnoreCase("") ? "" : lastName + ", ")
                + (prefix.equalsIgnoreCase("") ? "" : prefix + " ")
                + firstName
                + (middleName.equalsIgnoreCase("") ? "" : " " + middleName)
                + (suffix.equalsIgnoreCase("") ? "" : ", " + suffix);
    }

    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    public static String format(String firstName, String middleName, String lastName) {
        return lastName + ", " + firstName + " "  + middleName;
    }

    public static String format(String fullName) {
        // prefix, firstName, middleName, lastName, suffix
        String[] nameParts = {"", "", "", "", ""};

        // get suffix
        // check if suffix exists
        int comma = fullName.indexOf(',');
        if(comma != -1) {
            nameParts[4] = fullName.substring(comma + 1).trim();
        } else {
            nameParts[4] = "";
        }

        // check number of values before
        String firstPartOfName = fullName.substring(0, comma > 0 ? comma : fullName.length());
        String[] firstParts = firstPartOfName.split(" ");
//        System.out.println(firstPartOfName);
//        for (String part : firstParts) {
//            System.out.println(part);
//        }
//        System.out.println(firstParts.length);

        switch (firstParts.length) {
            case 1 -> { // assume first name only
                nameParts[1] = firstParts[0];
            }
            case 2 -> { // assume first and last name only
                nameParts[1] = firstParts[0];
                nameParts[3] = firstParts[1];
            }
            case 3 -> { // middle name or prefix
                if (firstParts[0].contains(".")) { // prefixes have .
                    System.out.println("Prefix");
                    nameParts[0] = firstParts[0];
                    nameParts[1] = firstParts[1];
                    nameParts[3] = firstParts[2];
                } else { // middle name
                    System.out.println("Middle");
                    nameParts[1] = firstParts[0];
                    nameParts[2] = firstParts[1];
                    nameParts[3] = firstParts[2];
                }
            }
            case 4 -> { // all parts of the name
                nameParts[0] = firstParts[0];
                nameParts[1] = firstParts[1];
                nameParts[2] = firstParts[2];
                nameParts[3] = firstParts[3];
            }
        }

        return format(nameParts[0], nameParts[1], nameParts[2], nameParts[3], nameParts[4]);
    }
}
