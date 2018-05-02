package rules;

import parser.syntaxtree.Judgment;

public class ApplicationRule extends TermRule
{
    public TermRule premise1Rule;
    public TermRule premise2Rule;

    public ApplicationRule(Judgment judgment, DerivationAnswer isDerivable, DerivationRule premise1Rule, DerivationRule premise2Rule)
    {
        this.judgment = judgment;
        this.premise1Rule = (TermRule) premise1Rule;
        this.premise2Rule = (TermRule) premise2Rule;
        this.isDerivable = isDerivable;
    }

    @Override
    public String toString()
    {
        String premise1String =  premise1Rule.judgment.toString();

        String premise2String =  premise2Rule.judgment.toString();

        String conclusionString = judgment.toString();

        int minSpaceLength = 4;

        int lineLength = Math.max(premise1String.length() + premise1String.length() + minSpaceLength,
                            conclusionString.length());

        int spaceLength = Math.max(minSpaceLength,
                lineLength - (premise1String.length() + premise1String.length()));

        String line = new String(new char[lineLength]).replace('\0', '-');
        String space= new String(new char[spaceLength]).replace('\0', ' ');

        return premise1String + space + premise2String + "\n" + line + "(app)" +"\n" + conclusionString;
    }
}
