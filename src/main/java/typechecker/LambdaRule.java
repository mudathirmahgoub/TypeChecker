package typechecker;

import parser.syntaxtree.Judgment;

public class LambdaRule extends DerivationRule
{
    public DerivationRule premiseRule;

    public LambdaRule(Judgment judgment, boolean isDerivable, DerivationRule premiseRule)
    {
        this.judgment = judgment;
        this.premiseRule = premiseRule;
        this.isDerivable = isDerivable;
    }

    @Override
    public String toString()
    {
        String premiseString =  premiseRule.judgment.toString();

        String conclusionString = judgment.toString();

        int lineLength = Math.max(premiseString.length(), conclusionString.length());

        String line = new String(new char[lineLength]).replace('\0', '-');

        return premiseString + "\n" + line +"(λ)"+ "\n" + conclusionString;
    }
}
