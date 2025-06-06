package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

class TestExercici0005 {

    @Test
    public void testIsPalindrom(TestInfo testInfo) throws Exception {
        try {
            String diff = TestStringUtils.findFirstDifference(
                String.valueOf(Exercici0005.isPalindrom("Anul·la la lluna")),
                String.valueOf(true)
            );
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<");

            diff = TestStringUtils.findFirstDifference(
                String.valueOf(Exercici0005.isPalindrom("Atrapa la lluna")),
                String.valueOf(false)
            );
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<");

            diff = TestStringUtils.findFirstDifference(
                String.valueOf(Exercici0005.isPalindrom("Atrapa'l o l'aparta")),
                String.valueOf(true)
            );
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<");
            System.out.println("Test passed, succeeded!");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }

    @Test
    public void testNormalize(TestInfo testInfo) throws Exception {
        try {
            String diff = TestStringUtils.findFirstDifference(
                Exercici0005.normalize("Anul·la la lluna"),
                "anullalalluna"
            );
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<");

            diff = TestStringUtils.findFirstDifference(
                Exercici0005.normalize("Atrapa la lluna"),
                "atrapalalluna"
            );
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<");
            System.out.println("Test passed, succeeded!");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }

    @Test
    public void testMainOutput(TestInfo testInfo) throws Exception {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            String text = SystemLambda.tapSystemOut(() -> {
                String[] args = {};
                Exercici0005.main(args); // Invocar el main
            });

            String expectedOutput = """
                Anul·la la lluna (Si)
                Atrapa la lluna (No)
                Atrapa'l o l'aparta (Si)
                Aparta'l o atrapa'l (No)
                No sap pas on (Si)
                On sap pas qui (No)
                Tramaran anar a Mart (Si)
                A Mart trobaràn art (No)
                Un pop nu (Si)
                Nu pop un (Si)
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }
}
