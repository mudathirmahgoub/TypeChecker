package parser.syntaxtree;

import org.junit.jupiter.api.Test;
import typechecker.TypeChecker;

import static org.junit.jupiter.api.Assertions.*;

class SystemFNodeTest
{
    @Test
    public void emptyContextVariableBaseType()
    {
        String input = ". |- x : T;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getProgram();
        assertEquals(0, program.subBases.size());
        assertEquals(0, program.judgment.typingContext.context.size());
        assertEquals(Variable.class, program.judgment.term.getClass());
        assertEquals("x", ((Variable) program.judgment.term).name);
        assertEquals(VariableType.class, program.judgment.type.getClass());
        assertEquals("T", ((VariableType)program.judgment.type).name);
    }

    @Test
    public void nonEmptyContextVariableBaseType()
    {
        String input = "x : T |- x : T;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getProgram();
        assertEquals(0, program.subBases.size());
        assertEquals(1, program.judgment.typingContext.context.size());

        Type type = program.judgment.typingContext.context.get("x");

        assertEquals(VariableType.class, type.getClass());
        assertEquals("T", ((VariableType)type).name);
        assertTrue(program.judgment.typingContext.context.containsKey("x"));
        assertEquals(1, program.judgment.typingContext.context.size());
        assertEquals(Variable.class, program.judgment.term.getClass());
        assertEquals("x", ((Variable) program.judgment.term).name);
        assertEquals(VariableType.class, program.judgment.type.getClass());
        assertEquals("T", ((VariableType)program.judgment.type).name);
    }

    
    @Test
    public void emptyContextVariableArrowType()
    {
        String input = ". |- x : T1 -> T2 ;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getProgram();

        assertEquals(ArrowType.class, program.judgment.type.getClass());

        ArrowType arrowType = (ArrowType)  program.judgment.type;

        assertEquals(VariableType.class, arrowType.domain.getClass());
        assertEquals("T1", ((VariableType) arrowType.domain).name);
        assertEquals(VariableType.class, arrowType.range.getClass());
        assertEquals("T2", ((VariableType) arrowType.range).name);
    }

    @Test
    public void emptyContextVariableArrowTypeArrowType()
    {
        String input = ". |- x : T1 -> T2 -> T3 ;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getProgram();

        assertEquals(ArrowType.class, program.judgment.type.getClass());

        ArrowType arrowType1 = (ArrowType)  program.judgment.type;

        assertEquals(VariableType.class, arrowType1.domain.getClass());
        assertEquals("T1", ((VariableType) arrowType1.domain).name);
        assertEquals(ArrowType.class, arrowType1.range.getClass());

        ArrowType arrowType2 = (ArrowType)  arrowType1.range;

        assertEquals(VariableType.class, arrowType2.domain.getClass());
        assertEquals("T2", ((VariableType) arrowType2.domain).name);
        assertEquals(VariableType.class, arrowType2.range.getClass());
        assertEquals("T3", ((VariableType) arrowType2.range).name);
    }

    @Test
    public void emptyContextVariableArrowTypeArrowTypeParenthesis()
    {
        String input = ". |- x : (T1 -> T2) -> T3 ;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getProgram();

        assertEquals(ArrowType.class, program.judgment.type.getClass());

        ArrowType arrowType1 = (ArrowType)  program.judgment.type;

        assertEquals(ArrowType.class, arrowType1.domain.getClass());
        ArrowType arrowType2 = (ArrowType)  arrowType1.domain;

        assertEquals(VariableType.class, arrowType2.domain.getClass());
        assertEquals("T1", ((VariableType) arrowType2.domain).name);
        assertEquals(VariableType.class, arrowType2.range.getClass());
        assertEquals("T2", ((VariableType) arrowType2.range).name);

        assertEquals(VariableType.class, arrowType1.range.getClass());
        assertEquals("T3", ((VariableType) arrowType1.range).name);
    }

    @Test
    public void emptyContextVariableForAllSimpleType()
    {
        String input = ". |- x : \\forall X. T ;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getProgram();

        assertEquals(ForAllType.class, program.judgment.type.getClass());

        ForAllType forAllType = (ForAllType)  program.judgment.type;

        assertEquals("X", forAllType.typeVariableName);
        assertEquals(VariableType.class, ((VariableType)forAllType.type).getClass());
        assertEquals("T", ((VariableType)forAllType.type).name);
    }

    @Test
    public void emptyContextVariableForAlArrowType()
    {
        String input = ". |- x : \\forall X. T1 -> T2 ;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getProgram();

        assertEquals(ForAllType.class, program.judgment.type.getClass());

        ForAllType forAllType = (ForAllType)  program.judgment.type;

        assertEquals("X", forAllType.typeVariableName);
        assertEquals(ArrowType.class, forAllType.type.getClass());

        ArrowType arrowType = (ArrowType) forAllType.type;

        assertEquals(VariableType.class, arrowType.domain.getClass());
        assertEquals("T1", ((VariableType) arrowType.domain).name);
        assertEquals(VariableType.class, arrowType.range.getClass());
        assertEquals("T2", ((VariableType) arrowType.range).name);
    }

    @Test
    public void emptyContextLambda()
    {
        String input = ". |- \\lambda x.x : T1 -> T2;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getProgram();
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
        Program program = (Program) typeChecker.getProgram();
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
        Program program = (Program) typeChecker.getProgram();
        assertEquals(Application.class, program.judgment.term.getClass());
        Application application = (Application) program.judgment.term;

        assertEquals(Variable.class, application.function.getClass());
        assertEquals("t1", ((Variable)application.function).name);

        assertEquals(Variable.class, application.argument.getClass());
        assertEquals("t2", ((Variable)application.argument).name);

        assertEquals(VariableType.class, application.annotation.getClass());
        assertEquals("T1", ((VariableType)application.annotation).name);

        assertEquals(VariableType.class, program.judgment.type.getClass());
        assertEquals("T2", ((VariableType)program.judgment.type).name);
    }

    @Test
    public void subBaseEmptyContextVariableBaseType()
    {
        String input = "SubBase(bool, int);  . |- x : T;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getProgram();
        assertEquals(1, program.subBases.size());

        SubBase subBase1 = program.subBases.get(0);
        assertEquals("bool", subBase1.subType);
        assertEquals("int", subBase1.superType);
    }

    @Test
    public void subBasesEmptyContextVariableBaseType()
    {
        String input = "SubBase(bool, int); SubBase(int, bool); . |- x : T;";
        TypeChecker typeChecker = new TypeChecker(input);
        Program program = (Program) typeChecker.getProgram();
        assertEquals(2, program.subBases.size());

        SubBase subBase1 = program.subBases.get(0);
        assertEquals("bool", subBase1.subType);
        assertEquals("int", subBase1.superType);

        SubBase subBase2 = program.subBases.get(1);
        assertEquals("int", subBase2.subType);
        assertEquals("bool", subBase2.superType);
    }
}