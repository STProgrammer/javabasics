package Modul03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PostfixNotationTest {
    private PostfixNotation postfixNotation;

    @BeforeEach
    void setUp() {
        postfixNotation = new PostfixNotation();
    }

    @ParameterizedTest
    @CsvSource({"2 2 +,4", "2 2 -,0", "2 3 *,6", "2 2 /,1"})
    void evaluateExpression_SimpleOperands_ReturnsFourZeroSixOne(String expression, int expectedResult) {
        assertThat(postfixNotation.evaluateExpression(expression), is(expectedResult));
    }

    @Test
    void evaluateExpression_MultipleOperands_ReturnsEighteen() {
        assertThat(postfixNotation.evaluateExpression("4 2 + 3 5 1 - * +"), is(18));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "       "})
    void evaluateExpression_EmptyStrings_ThrowsIllegalArgumentException(String expression) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    postfixNotation.evaluateExpression(expression);
                });
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/", "+-*/", "+ - * /"})
    void evaluateExpression_OperandsOnEmptyStack_ThrowsIllegalArgumentException(String expression) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    postfixNotation.evaluateExpression(expression);
                });
    }

    @Test
    void evaluateExpression_TooManyOrMisplacedOperands_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    postfixNotation.evaluateExpression("2 2 + * + / -");
                });
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "$", ",!|", "^", "3b54.,@"})
    void evaluateExpression_IllegalCharacters_ThrowsIllegalArgumentException(String expression) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    postfixNotation.evaluateExpression(expression);
                });
    }
}