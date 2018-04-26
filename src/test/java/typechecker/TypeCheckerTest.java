package typechecker;

import org.junit.jupiter.api.Test;
import parser.syntaxtree.*;

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
        assertNull(answer.rule);
    }

    @Test
    public void testVariableRule()
    {
        String program = "x : T |- x : T;";
        TypeChecker typeChecker = new TypeChecker(program);
        Answer answer= typeChecker.check();
        assertTrue(answer.isDerivable);
        assertNotNull(answer.rule);
        assertEquals(VariableRule.class, answer.rule.getClass());

        Judgment judgment = ((VariableRule) answer.rule).judgment;

        assertTrue(judgment.typingContext.context.containsKey("x"));
        BaseType contextType = (BaseType) judgment.typingContext.context.get("x");
        assertEquals("T", contextType.name);
        assertEquals("x", ((Variable) judgment.term).name);
        assertEquals("T", ((BaseType) judgment.type).name);
    }

    @Test
    public void testLambdaRule()
    {
        String program = "x : T |- \\lambda x. x : T -> T;";
        TypeChecker typeChecker = new TypeChecker(program);
        Answer answer= typeChecker.check();
        assertTrue(answer.isDerivable);
        assertNotNull(answer.rule);
        assertEquals(LambdaRule.class, answer.rule.getClass());

        Judgment lambdaJudgment = ((LambdaRule) answer.rule).judgment;

        assertTrue(lambdaJudgment.typingContext.context.containsKey("x"));
        BaseType contextType1 = (BaseType) lambdaJudgment.typingContext.context.get("x");
        assertEquals("T", contextType1.name);
        assertEquals("x", ((Lambda) lambdaJudgment.term).variable);
        Variable term = (Variable) ((Lambda) lambdaJudgment.term).term;
        assertEquals("x", term.name);

        ArrowType arrowType = (ArrowType) lambdaJudgment.type;

        assertEquals("T",((BaseType)arrowType.domain).name);
        assertEquals("T",((BaseType)arrowType.range).name);

        Answer premiseAnswer = ((LambdaRule) answer.rule).premiseAnswer;
        assertTrue(premiseAnswer.isDerivable);
        Judgment judgment = ((VariableRule) premiseAnswer.rule).judgment;
        assertTrue(judgment.typingContext.context.containsKey("x"));
        BaseType contextType2 = (BaseType) judgment.typingContext.context.get("x");
        assertEquals("T", contextType2.name);
        assertEquals("x", ((Variable) judgment.term).name);
        assertEquals("T", ((BaseType) judgment.type).name);
    }
}