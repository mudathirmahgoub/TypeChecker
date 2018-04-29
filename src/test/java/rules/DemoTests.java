package rules;

import org.junit.jupiter.api.Test;
import printers.LatexPrinter;

import static org.junit.jupiter.api.Assertions.*;
import typechecker.TypeChecker;

public class DemoTests
{
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
}
