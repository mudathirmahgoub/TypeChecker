package typechecker;

import parser.syntaxtree.Judgment;

public class ApplicationRule extends DerivationRule
{
    public Answer premise1Answer;
    public Answer premise2Answer;
    public Judgment judgment;

    public ApplicationRule(Judgment judgment, Answer premise1Answer, Answer premise2Answer)
    {
        this.judgment = judgment;
        this.premise1Answer = premise1Answer;
        this.premise2Answer = premise2Answer;
    }
}
