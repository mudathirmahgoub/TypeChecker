package rules;

import parser.syntaxtree.Judgment;

public class ForAllIntroduction extends TermRule
{
    public TermRule premiseRule;

    public ForAllIntroduction(Judgment judgment, DerivationAnswer isDerivable, DerivationRule premiseRule)
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

        return premiseString + "\n" + line +"(introduction)"+ "\n" + conclusionString;
    }
}
