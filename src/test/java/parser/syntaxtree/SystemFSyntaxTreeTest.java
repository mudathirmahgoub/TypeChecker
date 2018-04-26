package parser.syntaxtree;

import org.junit.jupiter.api.Test;
import typechecker.TypeChecker;

import static org.junit.jupiter.api.Assertions.*;

class SystemFSyntaxTreeTest
{
    @Test
    public void emptyContextVariableBaseType()
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
    public void nonEmptyContextVariableBaseType()
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
    public void emptyContextVariableArrowType()
    {
        String input = ". |- x : T1 -> T2 ;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getSyntaxTree();

        assertEquals(ArrowType.class, program.judgment.type.getClass());

        ArrowType arrowType = (ArrowType)  program.judgment.type;

        assertEquals(BaseType.class, arrowType.domain.getClass());
        assertEquals("T1", ((BaseType) arrowType.domain).name);
        assertEquals(BaseType.class, arrowType.range.getClass());
        assertEquals("T2", ((BaseType) arrowType.range).name);
    }

    @Test
    public void emptyContextVariableArrowTypeArrowType()
    {
        String input = ". |- x : T1 -> T2 -> T3 ;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getSyntaxTree();

        assertEquals(ArrowType.class, program.judgment.type.getClass());

        ArrowType arrowType1 = (ArrowType)  program.judgment.type;

        assertEquals(BaseType.class, arrowType1.domain.getClass());
        assertEquals("T1", ((BaseType) arrowType1.domain).name);
        assertEquals(ArrowType.class, arrowType1.range.getClass());

        ArrowType arrowType2 = (ArrowType)  arrowType1.range;

        assertEquals(BaseType.class, arrowType2.domain.getClass());
        assertEquals("T2", ((BaseType) arrowType2.domain).name);
        assertEquals(BaseType.class, arrowType2.range.getClass());
        assertEquals("T3", ((BaseType) arrowType2.range).name);
    }

    @Test
    public void emptyContextVariableArrowTypeArrowTypeParenthesis()
    {
        String input = ". |- x : (T1 -> T2) -> T3 ;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getSyntaxTree();

        assertEquals(ArrowType.class, program.judgment.type.getClass());

        ArrowType arrowType1 = (ArrowType)  program.judgment.type;

        assertEquals(ArrowType.class, arrowType1.domain.getClass());
        ArrowType arrowType2 = (ArrowType)  arrowType1.domain;

        assertEquals(BaseType.class, arrowType2.domain.getClass());
        assertEquals("T1", ((BaseType) arrowType2.domain).name);
        assertEquals(BaseType.class, arrowType2.range.getClass());
        assertEquals("T2", ((BaseType) arrowType2.range).name);

        assertEquals(BaseType.class, arrowType1.range.getClass());
        assertEquals("T3", ((BaseType) arrowType1.range).name);
    }

    @Test
    public void emptyContextVariableForAllSimpleType()
    {
        String input = ". |- x : \\forall X. T ;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getSyntaxTree();

        assertEquals(ForAllType.class, program.judgment.type.getClass());

        ForAllType forAllType = (ForAllType)  program.judgment.type;

        assertEquals("X", forAllType.typeVariable);
        assertEquals(BaseType.class, ((BaseType)forAllType.type).getClass());
        assertEquals("T", ((BaseType)forAllType.type).name);
    }

    @Test
    public void emptyContextVariableForAlArrowType()
    {
        String input = ". |- x : \\forall X. T1 -> T2 ;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getSyntaxTree();

        assertEquals(ForAllType.class, program.judgment.type.getClass());

        ForAllType forAllType = (ForAllType)  program.judgment.type;

        assertEquals("X", forAllType.typeVariable);
        assertEquals(ArrowType.class, forAllType.type.getClass());

        ArrowType arrowType = (ArrowType) forAllType.type;

        assertEquals(BaseType.class, arrowType.domain.getClass());
        assertEquals("T1", ((BaseType) arrowType.domain).name);
        assertEquals(BaseType.class, arrowType.range.getClass());
        assertEquals("T2", ((BaseType) arrowType.range).name);
    }

    @Test
    public void emptyContextLambda()
    {
        String input = ". |- \\lambda x.x : T1 -> T2;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getSyntaxTree();
        assertEquals(Lambda.class, program.judgment.term.getClass());
        Lambda lambda = (Lambda) program.judgment.term;
        assertEquals("x", lambda.variable);
        assertEquals(Variable.class, lambda.term.getClass());
        assertEquals("x", ((Variable)lambda.term).name);
    }

    @Test
    public void emptyContextLambdaLambda()
    {
        String input = ". |- \\lambda x. \\lambda y . x : T1 -> T2 -> T1;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getSyntaxTree();
        assertEquals(Lambda.class, program.judgment.term.getClass());

        Lambda lambda1 = (Lambda) program.judgment.term;
        assertEquals("x", lambda1.variable);
        assertEquals(Lambda.class, lambda1.term.getClass());

        Lambda lambda2 = (Lambda) lambda1.term;
        assertEquals("y", lambda2.variable);
        assertEquals(Variable.class, lambda2.term.getClass());
        assertEquals("x", ((Variable)lambda2.term).name);
    }

    @Test
    public void emptyContextApplication()
    {
        String input = ". |- (t1 t2) [T1]: T2;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getSyntaxTree();
        assertEquals(Application.class, program.judgment.term.getClass());
        Application application = (Application) program.judgment.term;

        assertEquals(Variable.class, application.function.getClass());
        assertEquals("t1", ((Variable)application.function).name);

        assertEquals(Variable.class, application.argument.getClass());
        assertEquals("t2", ((Variable)application.argument).name);

        assertEquals(BaseType.class, application.annotation.getClass());
        assertEquals("T1", ((BaseType)application.annotation).name);

        assertEquals(BaseType.class, program.judgment.type.getClass());
        assertEquals("T2", ((BaseType)program.judgment.type).name);
    }
}