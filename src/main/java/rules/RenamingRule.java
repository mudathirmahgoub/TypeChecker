package rules;

import parser.syntaxtree.Judgment;

public class RenamingRule extends TermRule
{
    public TermRule premiseRule;

    public RenamingRule(Judgment judgment, DerivationAnswer isDerivable, DerivationRule premiseRule)
    {
        this.judgment = judgment;
        this.premiseRule = (TermRule) premiseRule;
        this.isDerivable = isDerivable;
    }

    @Override
    public String toString()
    {
        String premiseString =  premiseRule.judgment.toString();

        String conclusionString = judgment.toString();

        int lineLength = Math.max(premiseString.length(), conclusionString.length());

        String line = new String(new char[lineLength]).replace('\0', '-');

        return premiseString + "\n" + line +"(renaming)"+ "\n" + conclusionString;
    }
}
