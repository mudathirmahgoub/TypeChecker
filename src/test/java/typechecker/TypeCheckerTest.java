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

    @Test
    public void testApplicationRule()
    {
        String program = "x : T1 -> T2, y: T1 |- (x y)[T1]: T2;";

        TypeChecker typeChecker = new TypeChecker(program);
        Answer answer= typeChecker.check();

        assertTrue(answer.isDerivable);
        assertNotNull(answer.rule);
        assertEquals(ApplicationRule.class, answer.rule.getClass());

        Judgment applicationJudgment = ((ApplicationRule) answer.rule).judgment;

        assertTrue(applicationJudgment.typingContext.context.containsKey("x"));
        assertTrue(applicationJudgment.typingContext.context.containsKey("y"));

        ArrowType xType1 = (ArrowType) applicationJudgment.typingContext.context.get("x");
        BaseType yType = (BaseType) applicationJudgment.typingContext.context.get("y");
        assertEquals("T1", ((BaseType)xType1.domain).name);
        assertEquals("T2", ((BaseType)xType1.range).name);
        assertEquals("T1", yType.name);
        Application applicationTerm = (Application) applicationJudgment.term;
        assertEquals("x", ((Variable)applicationTerm.function).name);
        assertEquals("y", ((Variable)applicationTerm.argument).name);
        assertEquals("T1", ((BaseType)applicationTerm.annotation).name);

        BaseType baseType = (BaseType) applicationJudgment.type;

        assertEquals("T2",baseType.name);

        Answer premise1Answer = ((ApplicationRule) answer.rule).premise1Answer;
        assertTrue(premise1Answer.isDerivable);
        Judgment judgment1 = ((VariableRule) premise1Answer.rule).judgment;
        assertTrue(judgment1.typingContext.context.containsKey("x"));

        ArrowType xPremiseTypingContext = (ArrowType) judgment1.typingContext.context.get("x");
        ArrowType xPremiseType = (ArrowType) judgment1.type;
        assertEquals("T1", ((BaseType)xPremiseTypingContext.domain).name);
        assertEquals("T2", ((BaseType)xPremiseTypingContext.range).name);
        assertEquals("x", ((Variable) judgment1.term).name);
        assertEquals("T1", ((BaseType)xPremiseType.domain).name);
        assertEquals("T2", ((BaseType)xPremiseType.range).name);

        Answer premise2Answer = ((ApplicationRule) answer.rule).premise2Answer;
        Judgment judgment2 = ((VariableRule) premise2Answer.rule).judgment;

        BaseType yPremiseTypingContext = (BaseType) judgment1.typingContext.context.get("y");
        BaseType yPremiseType = (BaseType) judgment2.type;
        assertEquals("T1", yPremiseTypingContext.name);
        assertEquals("y", ((Variable) judgment2.term).name);
        assertEquals("T1", yPremiseType.name);
    }


    @Test
    public void testLambdaRuleApplicationRule()
    {
        String program = ". |- \\lambda x. \\lambda y. (x y)[T1]: (T1 ->T2 ) -> (T1 -> T2);";

        TypeChecker typeChecker = new TypeChecker(program);
        Answer answer= typeChecker.check();

        assertTrue(answer.isDerivable);

        System.out.println(answer.rule);
    }
}