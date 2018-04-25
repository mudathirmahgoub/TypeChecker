package parser.syntaxtree;

import org.junit.jupiter.api.Test;
import typechecker.TypeChecker;

import static org.junit.jupiter.api.Assertions.*;

class SystemFSyntaxTreeTest
{
    @Test
    public void simpleProgram()
    {
        String input = ". |- x : T;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getSyntaxTree();
        assertEquals(0, program.subBases.size());
        assertEquals(0, program.judgment.typingContext.context.size());
        assertEquals(Variable.class, program.judgment.term.getClass());
    }
}