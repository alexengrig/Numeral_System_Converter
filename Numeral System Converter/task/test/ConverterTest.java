import converter.Converter;
import converter.Main;
import org.hyperskill.hstest.v6.stage.BaseStageTest;
import org.hyperskill.hstest.v6.testcase.CheckResult;
import org.hyperskill.hstest.v6.testcase.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

class Clue {

    final String input;
    final String answer;
    final boolean provideAnswer;

    Clue(final String input, final String answer, final boolean provideAnswer) {
        this.input = input;
        this.answer = answer;
        this.provideAnswer = provideAnswer;
    }

    Clue(final String input, final String answer) {
        this(input, answer, false);
    }

    Clue(final String input) {
        this(input, null, false);
    }
}


public class ConverterTest extends BaseStageTest<Clue> {

    public ConverterTest() throws Exception {
        super(Main.class);
    }

    static TestCase<Clue> testToAnswer(final String input, final String answer, final boolean provideAnswer) {
        return new TestCase<Clue>()
            .setAttach(new Clue(input, answer, provideAnswer))
            .setInput(input);
    }

    @Override
    public List<TestCase<Clue>> generate() {
        return List.of(
            /* Tests with a hint: */
            testToAnswer("10\n11\n2\n", "1011", true),
            testToAnswer("1\n11111\n10\n", "5", true),
            testToAnswer("10\n1000\n36\n", "rs", true),
            testToAnswer("21\n4242\n6\n", "451552", true),
            testToAnswer("7\n12\n11\n", "9", true),
            testToAnswer("5\n300\n10\n", "75", true),
            testToAnswer("1\n11111\n5\n", "10", true),
            testToAnswer("10\n4\n1\n", "1111", true),

            /* Tests without a hint: */
            testToAnswer("10\n12\n2\n", "1100", false),
            testToAnswer("1\n1111111\n10\n", "7", false),
            testToAnswer("10\n1001\n36\n", "rt", false),
            testToAnswer("21\n4243\n6\n", "451553", false),
            testToAnswer("7\n13\n11\n", "a", false),
            testToAnswer("5\n301\n10\n", "76", false),
            testToAnswer("1\n111111\n5\n", "11", false),
            testToAnswer("10\n5\n1\n", "11111", false)
        );
    }

    @Override
    public CheckResult check(String reply, Clue clue) {
        final String[] lines = reply
            .lines()
            .filter(line -> !line.isEmpty())
            .toArray(String[]::new);

        if (lines.length == 0) {
            return new CheckResult(
                false,
                "Your program doesn't print any line."
            );
        }

        final String answer = lines[lines.length - 1];

        if (!answer.equals(clue.answer)) {
            if (clue.provideAnswer) {
                return new CheckResult(
                    false,
                    "Your answer is wrong.\n" +
                        "This is a sample test so we give you a hint.\n" +
                        "Input: " + clue.input + "\n" +
                        "Your answer: " + answer + "\n" +
                        "Correct answer: " + clue.answer
                );
            } else {
                return new CheckResult(
                    false,
                    "Your answer is wrong."
                );
            }
        }

        return new CheckResult(true);
    }

    private String removeEndZeros(String number) {
        if (!number.contains(".")) {
            return number;
        }
        while (number.endsWith("0")) {
            number = number.substring(0, number.length() - 1);
        }
        if (number.endsWith(".")) {
            number = number.substring(0, number.length() - 1);
        }
        return number;
    }

    // My tests

    @Test
    public void check_binary_to_decimal() {
        Converter converter = new Converter();
        int result = converter.convertToDecimal("11101000", 2);
        Assert.assertEquals(232, result);
    }

    @Test
    public void check_octal_to_decimal() {
        Converter converter = new Converter();
        int result = converter.convertToDecimal("75013", 8);
        Assert.assertEquals(31243, result);
    }

    @Test
    public void check_hex_to_decimal() {
        Converter converter = new Converter();
        int result = converter.convertToDecimal("FDA1", 16);
        Assert.assertEquals(64929, result);
    }

    @Test
    public void check_decimal_to_binary() {
        Converter converter = new Converter();
        String result = converter.convertFromDecimal(22, 2);
        Assert.assertEquals("10110", result);
    }

    @Test
    public void check_decimal_to_octal() {
        Converter converter = new Converter();
        String result = converter.convertFromDecimal(571, 8);
        Assert.assertEquals("1073", result);
    }

    @Test
    public void check_decimal_to_hex() {
        Converter converter = new Converter();
        String result = converter.convertFromDecimal(7467, 16);
        Assert.assertEquals("1D2B", result);
    }

    @Test public void check() {
        Converter converter = new Converter();
        String result = converter.convert("1010", 2, 16);
        Assert.assertEquals("A", result);
    }
}
