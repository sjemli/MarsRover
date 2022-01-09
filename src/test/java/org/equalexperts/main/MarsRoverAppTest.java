package org.equalexperts.main;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MarsRoverAppTest {

    @Test
    void should_main_output_final_position() {

        System.setIn(new ByteArrayInputStream(String.join("\n", "7", "2", "EAST", "LFFRB").getBytes()));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MarsRoverApp.main(new String[]{});

        String[] printedLines = outContent.toString().split(System.lineSeparator());
        String resultLine = printedLines[printedLines.length - 1];
        String expectedPrintedResult = "Rover final position is (6, 4) EAST";
        assertThat(resultLine, equalTo(expectedPrintedResult));
    }
}