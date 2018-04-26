package typechecker;

import parser.syntaxtree.Judgment;

public class ApplicationRule extends DerivationRule
{
    public Answer premise1Answer;
    public Answer premise2Answer;

    public ApplicationRule(Judgment judgment, Answer premise1Answer, Answer premise2Answer)
    {
        this.judgment = judgment;
        this.premise1Answer = premise1Answer;
        this.premise2Answer = premise2Answer;
    }

    @Override
    public String toString()
    {
        String premise1String =  premise1Answer.rule.judgment.toString();

        String premise2String =  premise2Answer.rule.judgment.toString();

        String conclusionString = judgment.toString();

        int minSpaceLength = 4;

        int lineLength = Math.max(premise1String.length() + premise1String.length() + minSpaceLength,
                            conclusionString.length());

        int spaceLength = Math.max(minSpaceLength,
                lineLength - (premise1String.length() + premise1String.length()));

        String line = new String(new char[lineLength]).replace('\0', '-');
        String space= new String(new char[spaceLength]).replace('\0', ' ');

        return premise1String + space + premise2String + "\n" + line + "\n" + conclusionString;
    }
}
