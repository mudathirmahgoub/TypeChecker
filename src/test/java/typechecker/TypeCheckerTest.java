package typechecker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeCheckerTest
{
    @Test
    public void testEmptyProgram()
    {
        String program = ". |- x : T;";
        TypeChecker typeChecker = new TypeChecker(program);
        Answer answer= typeChecker.check();
        assertTrue(answer.isDerivable);
    }
}