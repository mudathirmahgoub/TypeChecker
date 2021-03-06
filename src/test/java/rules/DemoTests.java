package rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parser.syntaxtree.SystemFNode;
import printers.DefaultPrinter;
import printers.LatexPrinter;

import static org.junit.jupiter.api.Assertions.*;
import typechecker.TypeChecker;

public class DemoTests
{

    @BeforeEach
    public void clearTypingContext()
    {
        SystemFNode.subTypes.clear();
        SystemFNode.variableTypeNames.clear();
    }

    @Test
    public void testValidVariableRule()
    {
        String program = "x : T |- x : T;";
        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();
        assertEquals(DerivationAnswer.Yes, rule.isDerivable);

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));

    }


    @Test
    public void testInvalidVariableRule()
    {
        String program = ". |- x : T;";
        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();
        assertEquals(DerivationAnswer.No, rule.isDerivable);
        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
    }


    @Test
    public void testDirectSubtyping()
    {
        String program = "SubBase(bool, int);" +
                "x : bool |- x : int;";
        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();
        assertEquals(DerivationAnswer.Yes, rule.isDerivable);
        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
    }

    @Test
    public void testInvalidSubtyping()
    {
        String program = "SubBase(bool, int);" +
                "x : int |- x : bool;";
        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();
        assertEquals(DerivationAnswer.No, rule.isDerivable);
        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
    }

    @Test
    public void testTransitiveSubtyping()
    {
        String program = "SubBase(bool, int);SubBase(int, double);" +
                "x : bool |- x : double;";
        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        assertEquals(DerivationAnswer.Yes, rule.isDerivable);

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
    }

    @Test
    public void testTransitiveTransitiveSubtyping()
    {
        String program = "SubBase(bool, int);SubBase(int, quotient);SubBase(quotient, double);" +
                "x : bool |- x : double;";
        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        assertEquals(DerivationAnswer.Yes, rule.isDerivable);

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
    }

    @Test
    public void testDirectArrowSubtyping()
    {
        String program = "SubBase(bool, int);" +
                "x : int -> bool |- x : bool -> int;";
        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));

        assertEquals(DerivationAnswer.Yes, rule.isDerivable);
    }

    @Test
    public void testValidArrowSubtyping()
    {
        String program = "SubBase(bool, int);" +
                "x : int -> bool |- x : int -> int;";
        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));

        assertEquals(DerivationAnswer.Yes, rule.isDerivable);
    }

    @Test
    public void testValidLambdaRuleApplicationRuleWithSubtyping()
    {
        String program = "SubBase(bool, int);" +
                ". |- \\lambda x. \\lambda y. (x y)[bool]: (int ->T) -> (bool -> T);";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertEquals(DerivationAnswer.Yes, rule.isDerivable);
    }

    @Test
    public void testInvalidArrowSubtyping()
    {
        String program = "SubBase(bool, int);" +
                "x : bool -> bool |- x : int -> int;";
        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));

        assertEquals(DerivationAnswer.No, rule.isDerivable);
    }

    @Test
    public void testInvalidLambdaRuleApplicationRuleWithSubtyping()
    {
        String program = "SubBase(bool, int);" +
                ". |- \\lambda x. \\lambda y. (x y)[int]: (bool ->T) -> (bool -> T);";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertEquals(DerivationAnswer.No, rule.isDerivable);
    }

    @Test
    public void testSimpleForAll1()
    {
        String program = "x: \\forall X.X |- x: \\forall X.X;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertEquals(DerivationAnswer.Yes, rule.isDerivable);

        DefaultPrinter defaultPrinter = new DefaultPrinter();
        System.out.println(defaultPrinter.print(rule));
    }

    @Test
    public void testSimpleForAll2()
    {
        String program = "x: \\forall X.X |- x: \\forall Y.Y;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertEquals(DerivationAnswer.Yes, rule.isDerivable);

        DefaultPrinter defaultPrinter = new DefaultPrinter();
        System.out.println(defaultPrinter.print(rule));
    }

    @Test
    public void testSimpleForAll3()
    {
        String program = "x: \\forall X.X -> X |- x: \\forall Y.Y -> Y;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertEquals(DerivationAnswer.Yes, rule.isDerivable);

        DefaultPrinter defaultPrinter = new DefaultPrinter();
        System.out.println(defaultPrinter.print(rule));
    }


    @Test
    public void testSimpleForAll4()
    {
        String program = "x: \\forall X.X -> Y |- x: \\forall Z.Z -> Y;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertEquals(DerivationAnswer.Yes, rule.isDerivable);

        DefaultPrinter defaultPrinter = new DefaultPrinter();
        System.out.println(defaultPrinter.print(rule));
    }


    @Test
    public void testSimpleForAll5()
    {
        String program = "x: \\forall X.X -> Y |- x: \\forall Y.Y -> Y;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertEquals(DerivationAnswer.No, rule.isDerivable);

        DefaultPrinter defaultPrinter = new DefaultPrinter();
        System.out.println(defaultPrinter.print(rule));
    }

    @Test
    public void testSimpleForAll6()
    {
        String program = "x: \\forall X.X -> Y |- x: \\forall Y.Y -> Z;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertEquals(DerivationAnswer.No, rule.isDerivable);

        DefaultPrinter defaultPrinter = new DefaultPrinter();
        System.out.println(defaultPrinter.print(rule));
    }


    @Test
    public void testSystemFEliminationRule1()
    {
        String program = "x: \\forall X.X |- x [[Y]]: Y;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertEquals(DerivationAnswer.Yes, rule.isDerivable);

        DefaultPrinter defaultPrinter = new DefaultPrinter();
        System.out.println(defaultPrinter.print(rule));
    }


    @Test
    public void testSystemFEliminationRule2()
    {
        String program = "x: \\forall X.X |- x [[Y->Y]]: Y-> Y;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        assertEquals(DerivationAnswer.Yes, rule.isDerivable);

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));

        DefaultPrinter defaultPrinter = new DefaultPrinter();
        System.out.println(defaultPrinter.print(rule));

    }

    @Test
    public void testSystemFEliminationRule3()
    {
        String program = "x: \\forall X.X |- (x[[(\\forall X.X) -> \\forall X.X]] x) [\\forall X.X]: \\forall X.X;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertEquals(DerivationAnswer.Yes, rule.isDerivable);

        DefaultPrinter defaultPrinter = new DefaultPrinter();
        System.out.println(defaultPrinter.print(rule));
    }

    @Test
    public void testSystemFZero()
    {
        String program = ". |- \\lambda s. \\lambda z. z : \\forall X. (X -> X) -> X -> X;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertEquals(DerivationAnswer.Yes, rule.isDerivable);

        DefaultPrinter defaultPrinter = new DefaultPrinter();
        System.out.println(defaultPrinter.print(rule));
    }

    @Test
    public void testSystemFZeroWithFreeVariableX()
    {
        String program = "y: X |- \\lambda s. \\lambda z. z : \\forall X. (X -> X) -> X -> X;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertEquals(DerivationAnswer.Yes, rule.isDerivable);

        DefaultPrinter defaultPrinter = new DefaultPrinter();
        System.out.println(defaultPrinter.print(rule));
    }

    @Test
    public void testSystemFSuccessorMissingAnnotation()
    {
        String program = ". |- \\lambda n. \\lambda s. \\lambda z. " +
                "(s ((n s)[X -> X] z)[X])[X]:" +
                "(\\forall X. (X -> X) -> X -> X) -> \\forall X. (X -> X) -> X -> X;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertEquals(DerivationAnswer.Unknown, rule.isDerivable);

        DefaultPrinter defaultPrinter = new DefaultPrinter();
        System.out.println(defaultPrinter.print(rule));
    }

    @Test
    public void testSystemFSuccessorWellAnnotated()
    {
        String program = ". |- \\lambda n. \\lambda s. \\lambda z. " +
                "(s ((n[[X]] s)[X -> X] z)[X])[X]:" +
                "(\\forall X. (X -> X) -> X -> X) -> \\forall X. (X -> X) -> X -> X;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertEquals(DerivationAnswer.Yes, rule.isDerivable);

        DefaultPrinter defaultPrinter = new DefaultPrinter();
        System.out.println(defaultPrinter.print(rule));
    }


    @Test
    public void testIntroductionApplication()
    {
        String program = "x: T_1 -> T_2, y : T_1 |- (x y) [T_1]: \\forall X. T_2;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertEquals(DerivationAnswer.Yes, rule.isDerivable);

        DefaultPrinter defaultPrinter = new DefaultPrinter();
        System.out.println(defaultPrinter.print(rule));
    }

    @Test
    public void testEliminationApplication()
    {
        String program = "x: T_1 -> \\forall X. T_2, y : T_1 |- (x y) [T_1][[Y]]: T_2;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertEquals(DerivationAnswer.Yes, rule.isDerivable);

        DefaultPrinter defaultPrinter = new DefaultPrinter();
        System.out.println(defaultPrinter.print(rule));
    }
}
