package rules;

import org.junit.jupiter.api.Test;
import parser.syntaxtree.*;
import printers.DefaultPrinter;
import printers.LatexPrinter;
import typechecker.TypeChecker;

import static org.junit.jupiter.api.Assertions.*;

class TypeCheckerTest
{
    @Test
    public void testEmptyContextVariableRule()
    {
        String program = ". |- x : T;";
        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();
        assertFalse(rule.isDerivable);
    }

    @Test
    public void testVariableRule()
    {
        String program = "x : T |- x : T;";
        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();
        assertTrue(rule.isDerivable);
        
        assertEquals(VariableRule.class, rule.getClass());

        Judgment judgment = ((VariableRule) rule).judgment;

        assertTrue(judgment.typingContext.context.containsKey("x"));
        VariableType contextType = (VariableType) judgment.typingContext.context.get("x");
        assertEquals("T", contextType.name);
        assertEquals("x", ((Variable) judgment.term).name);
        assertEquals("T", ((VariableType) judgment.type).name);
    }

    @Test
    public void testLambdaRule()
    {
        String program = "x : T |- \\lambda x. x : T -> T;";
        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();
        assertTrue(rule.isDerivable);
        assertNotNull(rule);
        assertEquals(LambdaRule.class, rule.getClass());

        Judgment lambdaJudgment = ((LambdaRule) rule).judgment;

        assertTrue(lambdaJudgment.typingContext.context.containsKey("x"));
        VariableType contextType1 = (VariableType) lambdaJudgment.typingContext.context.get("x");
        assertEquals("T", contextType1.name);
        assertEquals("x", ((Lambda) lambdaJudgment.term).variable);
        Variable term = (Variable) ((Lambda) lambdaJudgment.term).term;
        assertEquals("x", term.name);

        ArrowType arrowType = (ArrowType) lambdaJudgment.type;

        assertEquals("T",((VariableType)arrowType.domain).name);
        assertEquals("T",((VariableType)arrowType.range).name);

        DerivationRule premiseRule = ((LambdaRule) rule).premiseRule;
        assertTrue(premiseRule.isDerivable);
        Judgment judgment = ((VariableRule) premiseRule).judgment;
        assertTrue(judgment.typingContext.context.containsKey("x"));
        VariableType contextType2 = (VariableType) judgment.typingContext.context.get("x");
        assertEquals("T", contextType2.name);
        assertEquals("x", ((Variable) judgment.term).name);
        assertEquals("T", ((VariableType) judgment.type).name);
    }

    @Test
    public void testApplicationRule()
    {
        String program = "x : T1 -> T2, y: T1 |- (x y)[T1]: T2;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        assertTrue(rule.isDerivable);
        assertNotNull(rule);
        assertEquals(ApplicationRule.class, rule.getClass());

        Judgment applicationJudgment = ((ApplicationRule) rule).judgment;

        assertTrue(applicationJudgment.typingContext.context.containsKey("x"));
        assertTrue(applicationJudgment.typingContext.context.containsKey("y"));

        ArrowType xType1 = (ArrowType) applicationJudgment.typingContext.context.get("x");
        VariableType yType = (VariableType) applicationJudgment.typingContext.context.get("y");
        assertEquals("T1", ((VariableType)xType1.domain).name);
        assertEquals("T2", ((VariableType)xType1.range).name);
        assertEquals("T1", yType.name);
        Application applicationTerm = (Application) applicationJudgment.term;
        assertEquals("x", ((Variable)applicationTerm.function).name);
        assertEquals("y", ((Variable)applicationTerm.argument).name);
        assertEquals("T1", ((VariableType)applicationTerm.annotation).name);

        VariableType variableType = (VariableType) applicationJudgment.type;

        assertEquals("T2", variableType.name);

        DerivationRule premise1Rule = ((ApplicationRule) rule).premise1Rule;
        assertTrue(premise1Rule.isDerivable);
        Judgment judgment1 = ((VariableRule) premise1Rule).judgment;
        assertTrue(judgment1.typingContext.context.containsKey("x"));

        ArrowType xPremiseTypingContext = (ArrowType) judgment1.typingContext.context.get("x");
        ArrowType xPremiseType = (ArrowType) judgment1.type;
        assertEquals("T1", ((VariableType)xPremiseTypingContext.domain).name);
        assertEquals("T2", ((VariableType)xPremiseTypingContext.range).name);
        assertEquals("x", ((Variable) judgment1.term).name);
        assertEquals("T1", ((VariableType)xPremiseType.domain).name);
        assertEquals("T2", ((VariableType)xPremiseType.range).name);

        DerivationRule premise2Rule = ((ApplicationRule) rule).premise2Rule;
        Judgment judgment2 = ((VariableRule) premise2Rule).judgment;

        VariableType yPremiseTypingContext = (VariableType) judgment1.typingContext.context.get("y");
        VariableType yPremiseType = (VariableType) judgment2.type;
        assertEquals("T1", yPremiseTypingContext.name);
        assertEquals("y", ((Variable) judgment2.term).name);
        assertEquals("T1", yPremiseType.name);
    }


    @Test
    public void testLambdaRuleApplicationRule()
    {
        String program = ". |- \\lambda x. \\lambda y. (x y)[T1]: (T1 ->T2 ) -> (T1 -> T2);";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        assertTrue(rule.isDerivable);

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));

        DefaultPrinter defaultPrinter = new DefaultPrinter();
        String print = defaultPrinter.print(rule);
        System.out.println(print);

        String results = "------------------------------------(var)\t-----------------------------(var)\t\n" +
                "x: (T1 → T2), y: T1 ⊢ x : (T1 → T2)\t\t\tx: (T1 → T2), y: T1 ⊢ y : T1\t\n" +
                "-------------------------------------------------------------------------(app)\n" +
                "x: (T1 → T2), y: T1 ⊢ (x y) [T1] : T2\n" +
                "-----------------------------------------(λ)\n" +
                "x: (T1 → T2) ⊢ λy. (x y) [T1] : (T1 → T2)\n" +
                "------------------------------------------------(λ)\n" +
                "· ⊢ λx. λy. (x y) [T1] : ((T1 → T2) → (T1 → T2))";

        assertEquals(results, print);
    }
}