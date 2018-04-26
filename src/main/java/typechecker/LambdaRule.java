package typechecker;

import parser.syntaxtree.Judgment;

public class LambdaRule extends DerivationRule
{
    public Answer premiseAnswer;
    public Judgment judgment;
    public LambdaRule(Judgment judgment, Answer premiseAnswer)
    {
        this.judgment = judgment;
        this.premiseAnswer = premiseAnswer;
    }
}
