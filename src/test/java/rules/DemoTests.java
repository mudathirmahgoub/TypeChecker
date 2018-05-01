package rules;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parser.syntaxtree.SystemFNode;
import printers.LatexPrinter;

import static org.junit.jupiter.api.Assertions.*;
import typechecker.TypeChecker;

public class DemoTests
{

    @BeforeEach
    public void clearTypingContext()
    {
        SystemFNode.subTypes.clear();
    }

    @Test
    public void testValidVariableRule()
    {
        String program = "x : T |- x : T;";
        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();
        assertTrue(rule.isDerivable);

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));

    }


    @Test
    public void testInvalidVariableRule()
    {
        String program = ". |- x : T;";
        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();
        assertFalse(rule.isDerivable);
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
        assertTrue(rule.isDerivable);
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
        assertFalse(rule.isDerivable);
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

        assertTrue(rule.isDerivable);

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

        assertTrue(rule.isDerivable);

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

        assertTrue(rule.isDerivable);
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

        assertTrue(rule.isDerivable);
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
        assertTrue(rule.isDerivable);
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

        assertFalse(rule.isDerivable);
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
        assertFalse(rule.isDerivable);
    }

    @Test
    public void testSimpleForAll1()
    {
        String program = "x: \\forall X.X |- x: \\forall X.X;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertTrue(rule.isDerivable);
    }

    @Test
    public void testSimpleForAll2()
    {
        String program = "x: \\forall X.X |- x: \\forall Y.Y;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertTrue(rule.isDerivable);
    }

    @Test
    public void testSimpleForAll3()
    {
        String program = "x: \\forall X.X -> X |- x: \\forall Y.Y -> Y;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertTrue(rule.isDerivable);
    }


    @Test
    public void testSimpleForAll4()
    {
        String program = "x: \\forall X.X -> Y |- x: \\forall Z.Z -> Y;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertTrue(rule.isDerivable);
    }


    @Test
    public void testSimpleForAll5()
    {
        String program = "x: \\forall X.X -> Y |- x: \\forall Y.Y -> Y;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertFalse(rule.isDerivable);
    }

    @Test
    public void testSimpleForAll6()
    {
        String program = "x: \\forall X.X -> Y |- x: \\forall Y.Y -> Z;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertFalse(rule.isDerivable);
    }


    @Test
    public void testSystemFEliminationRule1()
    {
        String program = "x: \\forall X.X |- x [Y]: Y;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertTrue(rule.isDerivable);
    }


    @Test
    public void testSystemFEliminationRule2()
    {
        String program = "x: \\forall X.X |- x [Y]: Y-> Y;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertTrue(rule.isDerivable);
    }

    @Test
    public void testSystemFApplication()
    {
        String program = "x: \\forall X.X |- (x x) [\\forall X.X]: \\forall X.X;";

        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
        assertTrue(rule.isDerivable);
    }
//
//    @Test
//    public void testSystemF()
//    {
//        String program = ". |- \\lambda x. (x x) [\\forall Y.Y]: \\forall X. (\\forall Y.Y) -> X;";
//
//        TypeChecker typeChecker = new TypeChecker(program);
//        DerivationRule rule= typeChecker.check();
//
//        LatexPrinter latexPrinter = new LatexPrinter();
//        System.out.println(latexPrinter.print(rule));
//        assertFalse(rule.isDerivable);
//    }
}
