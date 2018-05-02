package parser.syntaxtree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import typechecker.TypeChecker;

import static org.junit.jupiter.api.Assertions.*;

class TypingContextTest
{
    @BeforeEach
    public void clearTypingContext()
    {
        SystemFNode.subTypes.clear();
        SystemFNode.variableTypeNames.clear();
    }

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

    @Test
    public void testGetNewVariable1()
    {
        String program = "x: X, y: \\forall Y. (Y -> Z) -> Y |- x : X;";

        TypeChecker typeChecker = new TypeChecker(program);
        assertEquals("X1", SystemFNode.getNewVariableTypeName());
        assertEquals("X2", SystemFNode.getNewVariableTypeName());
        assertEquals("X3", SystemFNode.getNewVariableTypeName());
    }

    @Test
    public void testGetNewVariable2()
    {
        String program = "x: X1, y: \\forall Y. (Y -> X2) -> Y |- x : X3;";

        TypeChecker typeChecker = new TypeChecker(program);
        assertEquals("X4", SystemFNode.getNewVariableTypeName());
        assertEquals("X5", SystemFNode.getNewVariableTypeName());
        assertEquals("X6", SystemFNode.getNewVariableTypeName());
    }

}