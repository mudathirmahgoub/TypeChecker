package parser.syntaxtree;

import org.junit.jupiter.api.Test;
import typechecker.TypeChecker;

import static org.junit.jupiter.api.Assertions.*;

class SystemFSyntaxTreeTest
{
    @Test
    public void emptyContextBaseType()
    {
        String input = ". |- x : T;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getSyntaxTree();
        assertEquals(0, program.subBases.size());
        assertEquals(0, program.judgment.typingContext.context.size());
        assertEquals(Variable.class, program.judgment.term.getClass());
        assertEquals("x", ((Variable) program.judgment.term).name);
        assertEquals(BaseType.class, program.judgment.type.getClass());
        assertEquals("T", ((BaseType)program.judgment.type).name);
    }

    @Test
    public void nonEmptyContextBaseType()
    {
        String input = "x : T |- x : T;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getSyntaxTree();
        assertEquals(0, program.subBases.size());
        assertEquals(1, program.judgment.typingContext.context.size());

        Type type = program.judgment.typingContext.context.get("x");

        assertEquals(BaseType.class, type.getClass());
        assertEquals("T", ((BaseType)type).name);
        assertTrue(program.judgment.typingContext.context.containsKey("x"));
        assertEquals(1, program.judgment.typingContext.context.size());
        assertEquals(Variable.class, program.judgment.term.getClass());
        assertEquals("x", ((Variable) program.judgment.term).name);
        assertEquals(BaseType.class, program.judgment.type.getClass());
        assertEquals("T", ((BaseType)program.judgment.type).name);
    }

    @Test
    public void emptyContextArrowType()
    {
        String input = ". |- x : T1 -> T2 ;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getSyntaxTree();
        assertEquals(0, program.subBases.size());
        assertEquals(0, program.judgment.typingContext.context.size());
        assertEquals(Variable.class, program.judgment.term.getClass());
        assertEquals("x", ((Variable) program.judgment.term).name);
        assertEquals(ArrowType.class, program.judgment.type.getClass());

        ArrowType arrowType = (ArrowType)  program.judgment.type;

        assertEquals(BaseType.class, arrowType.domain.getClass());
        assertEquals("T1", ((BaseType) arrowType.domain).name);
        assertEquals(BaseType.class, arrowType.range.getClass());
        assertEquals("T2", ((BaseType) arrowType.range).name);
    }
}