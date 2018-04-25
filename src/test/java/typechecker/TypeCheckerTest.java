package typechecker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeCheckerTest
{
    @Test
    public void testEmptyContextVariableRule()
    {
        String program = ". |- x : T;";
        TypeChecker typeChecker = new TypeChecker(program);
        Answer answer= typeChecker.check();
        assertFalse(answer.isDerivable);
    }

    @Test
    public void testVariableRule()
    {
        String program = "x : T |- x : T;";
        TypeChecker typeChecker = new TypeChecker(program);
        Answer answer= typeChecker.check();
        assertTrue(answer.isDerivable);
    }
}