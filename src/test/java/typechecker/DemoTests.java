package typechecker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DemoTests
{
    @Test
    public void testEmptyContextVariableRule()
    {
        String program = "SubBase(bool, int);" +
                "x : bool |- x : int;";
        TypeChecker typeChecker = new TypeChecker(program);
        DerivationRule rule= typeChecker.check();
        DefaultPrinter printer = new DefaultPrinter();
        System.out.println(printer.print(rule));

        LatexPrinter latexPrinter = new LatexPrinter();
        System.out.println(latexPrinter.print(rule));

        assertTrue(rule.isDerivable);
    }
}
