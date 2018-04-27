package typechecker;

import parser.syntaxtree.Judgment;

public class VariableRule extends DerivationRule
{

    public VariableRule(Judgment judgment, boolean isDerivable)
    {
        this.judgment = judgment;
        this.isDerivable = isDerivable;
    }

    @Override
    public String toString()
    {
        String premiseString =  judgment.typingContext + "(" + judgment.term + ")" +
                " = " + judgment.type;
        String conclusionString = judgment.toString();
        int length = Math.max(premiseString.length(), conclusionString.length() );

        String line = new String(new char[length]).replace('\0', '-');

        return premiseString + "\n" + line + "(var)" + "\n" + conclusionString;
    }
}
