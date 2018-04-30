package parser.syntaxtree;

import org.junit.jupiter.api.Test;
import typechecker.TypeChecker;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;

class ForAllTypeTest
{
    @Test
    public void testRenaming1()
    {
        String program = ".|- x : \\forall X. X;";

        TypeChecker typeChecker = new TypeChecker(program);
        Type type = typeChecker.getProgram().judgment.type;
        ForAllType oldType = (ForAllType) type;
        ForAllType newType = oldType.rename("Y");

        assertEquals("∀Y. Y", newType.toString());
    }
    @Test
    public void testRenaming2()
    {
        String program = ".|- x : \\forall X. X -> Y;";

        TypeChecker typeChecker = new TypeChecker(program);
        Type type = typeChecker.getProgram().judgment.type;
        ForAllType oldType = (ForAllType) type;
        ForAllType newType = oldType.rename("Z");

        assertEquals("∀Z. (Z → Y)", newType.toString());
    }
    @Test
    public void testRenamingFreeVariable()
    {
        String program = ".|- x : \\forall X. X -> Y;";

        TypeChecker typeChecker = new TypeChecker(program);
        Type type = typeChecker.getProgram().judgment.type;
        ForAllType oldType = (ForAllType) type;

        Executable executable = () -> oldType.rename("Y");

        assertThrows(UnsupportedOperationException.class, executable,
                "Y is free in ∀X. (X → Y)");
    }

    @Test
    public void testEquality1()
    {
        String program = "x : \\forall X. X |- x : \\forall X. X;";

        TypeChecker typeChecker = new TypeChecker(program);
        Type type1 = typeChecker.getProgram().judgment.typingContext.context.get("x");
        Type type2 = typeChecker.getProgram().judgment.type;

        assertEquals(type1, type2);
    }

    @Test
    public void testEquality2()
    {
        String program = "x : \\forall X. X |- x : \\forall Y. Y;";

        TypeChecker typeChecker = new TypeChecker(program);
        Type type1 = typeChecker.getProgram().judgment.typingContext.context.get("x");
        Type type2 = typeChecker.getProgram().judgment.type;

        assertEquals(type1, type2);
    }

    @Test
    public void testEquality3()
    {
        String program = "x : \\forall X. X -> Y |- x : \\forall Y. X -> Y;";

        TypeChecker typeChecker = new TypeChecker(program);
        Type type1 = typeChecker.getProgram().judgment.typingContext.context.get("x");
        Type type2 = typeChecker.getProgram().judgment.type;
        assertNotEquals(type1, type2);
    }
}