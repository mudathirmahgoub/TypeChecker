package typechecker;

import parser.syntaxtree.Judgment;

public class LambdaRule extends DerivationRule
{
    public Answer premiseAnswer;

    public LambdaRule(Judgment judgment, Answer premiseAnswer)
    {
        this.judgment = judgment;
        this.premiseAnswer = premiseAnswer;
    }

    @Override
    public String toString()
    {
        String premiseString =  premiseAnswer.rule.judgment.toString();

        String conclusionString = judgment.toString();

        int lineLength = Math.max(premiseString.length(), conclusionString.length());

        String line = new String(new char[lineLength]).replace('\0', '-');

        return premiseString + "\n" + line + "\n" + conclusionString;
    }
}
