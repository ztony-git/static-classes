package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameFormatterTest {
    @Test
    void formatFirstLast_GivenFirstAndLastName_LastFirst() {
        String firstName = "Tony";
        String lastName = "Zhang";

        String name = NameFormatter.format(firstName, lastName);

        String expected = "Zhang, Tony";
        assertEquals(expected, name);
        // -----------------------------
        firstName = "Mel";
        lastName = "Johnson";

        name = NameFormatter.format(firstName, lastName);

        expected = "Johnson, Mel";
        assertEquals(expected, name);
    }

    @Test
    void formatPrefixFirstMiddleLastSuffix_GivenAllPartsOfName_LastPrefixFirstMiddleSuffix() {
        String prefix = "Mr.";
        String firstName = "Tony";
        String middleName = "T";
        String lastName = "Zhang";
        String suffix = "PhD";

        String name = NameFormatter.format(prefix, firstName, middleName, lastName, suffix);

        String expected = "Zhang, Mr. Tony T, PhD";
        assertEquals(expected, name);
        // ---------------------
        prefix = "Dr.";
        firstName = "Mel";
        middleName = "B";
        lastName = "Johnson";
        suffix = "PhD";

        name = NameFormatter.format(prefix, firstName, middleName, lastName, suffix);

        expected = "Johnson, Dr. Mel B, PhD";
        assertEquals(expected, name);
    }

    @Test
    void formatFull_GivenFullName_LastPrefixFirstMiddleSuffix() {
        String fullName = "Mr. Tony T Zhang, PhD";

        String name = NameFormatter.format(fullName);

        String expected = "Zhang, Mr. Tony T, PhD";
        assertEquals(expected, name);
    }

    @Test
    void formatFull_GivenNoSuffix_LastPrefixFirstMiddle() {
        String fullName = "Mr. Tony T Zhang";

        String name = NameFormatter.format(fullName);

        String expected = "Zhang, Mr. Tony T";
        assertEquals(expected, name);
    }

    @Test
    void formatFull_GivenNoPrefix_LastFirstMiddleSuffix() {
        String fullName = "Tony T Zhang, PhD";

        String name = NameFormatter.format(fullName);

        String expected = "Zhang, Tony T, PhD";
        assertEquals(expected, name);
    }

    @Test
    void formatFull_GivenNoMiddle_LastPrefixFirstSuffix() {
        String fullName = "Mr. Tony Zhang, PhD";

        String name = NameFormatter.format(fullName);

        String expected = "Zhang, Mr. Tony, PhD";
        assertEquals(expected, name);
    }

    @Test
    void formatFull_GivenNoMiddlePrefix_LastFirstSuffix() {
        String fullName = "Tony Zhang, PhD";

        String name = NameFormatter.format(fullName);

        String expected = "Zhang, Tony, PhD";
        assertEquals(expected, name);
    }

    @Test
    void formatFull_GivenFirstLand_LastFirst() {
        String fullName = "Tony Zhang";

        String name = NameFormatter.format(fullName);

        String expected = "Zhang, Tony";
        assertEquals(expected, name);
    }

    @Test
    void formatFull_GivenFirst_First() {
        String fullName = "Tony";

        String name = NameFormatter.format(fullName);

        String expected = "Tony";
        assertEquals(expected, name);
    }

    @Test
    void formatFull_GivenFirstSuffix_FirstSuffix() {
        String fullName = "Tony, PhD";

        String name = NameFormatter.format(fullName);

        String expected = "Tony, PhD";
        assertEquals(expected, name);
    }
}