package typechecker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

        assertTrue(rule.isDerivable);

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));
    }
}
