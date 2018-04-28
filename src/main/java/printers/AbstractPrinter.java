package printers;

import rules.DerivationRule;

public abstract class AbstractPrinter
{
    abstract public String print(DerivationRule rule);
}
