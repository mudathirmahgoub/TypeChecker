package typechecker;

import parser.syntaxtree.Judgment;

public class VariableRule extends DerivationRule
{
    public Judgment judgment;
    public VariableRule(Judgment judgment)
    {
        this.judgment = judgment;
    }
}
