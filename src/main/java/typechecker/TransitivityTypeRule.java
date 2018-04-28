package typechecker;

public class TransitivityTypeRule extends  DerivationRule
{
    public DerivationRule premise1Rule;
    public DerivationRule premise2Rule;
    public SubtypeJudgment subtypeJudgment;
    public TransitivityTypeRule(SubtypeJudgment subtypeJudgment,
                                DerivationRule premise1Rule, DerivationRule premise2Rule )
    {
        this.subtypeJudgment = subtypeJudgment;
        this.premise1Rule = premise1Rule;
        this.premise2Rule = premise2Rule;
    }
}
