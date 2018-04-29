package rules;

public class InvalidTypeRule extends SubtypeRule
{

    public InvalidTypeRule(SubtypeJudgment subtypeJudgment)
    {
        this.subtypeJudgment = subtypeJudgment;
        this.isDerivable = false;
    }
}
