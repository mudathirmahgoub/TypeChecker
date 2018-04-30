package parser.syntaxtree;

import org.junit.jupiter.api.Test;
import typechecker.TypeChecker;

import static org.junit.jupiter.api.Assertions.*;

class TypingContextTest
{
    @Test
    public void testFreeVariables1()
    {
        String program = "x: X, y: \\forall Y. Y |- x : X;";

        TypeChecker typeChecker = new TypeChecker(program);
        TypingContext typingContext = typeChecker.getProgram().judgment.typingContext;
        assertTrue(typingContext.isFreeType("X"));
        assertFalse(typingContext.isFreeType("Y"));
        assertFalse(typingContext.isFreeType("Z"));
    }

    @Test
    public void testFreeVariables2()
    {
        String program = "x: Y -> X, y: \\forall Y. (Y -> Z) -> Y |- x : X;";

        TypeChecker typeChecker = new TypeChecker(program);
        TypingContext typingContext = typeChecker.getProgram().judgment.typingContext;
        assertTrue(typingContext.isFreeType("X"));
        assertTrue(typingContext.isFreeType("Y"));
        assertTrue(typingContext.isFreeType("Z"));
    }

    @Test
    public void testFreeVariables3()
    {
        String program = "x: X, y: \\forall Y. (Y -> Z) -> Y |- x : X;";

        TypeChecker typeChecker = new TypeChecker(program);
        TypingContext typingContext = typeChecker.getProgram().judgment.typingContext;
        assertTrue(typingContext.isFreeType("X"));
        assertFalse(typingContext.isFreeType("Y"));
        assertTrue(typingContext.isFreeType("Z"));
    }
}