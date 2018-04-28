package rules;

public class TransitivityTypeRule extends SubtypeRule
{
    public DerivationRule premise1Rule;
    public DerivationRule premise2Rule;
    public TransitivityTypeRule(SubtypeJudgment subtypeJudgment, boolean isDerivable,
                                DerivationRule premise1Rule, DerivationRule premise2Rule )
    {
        this.subtypeJudgment = subtypeJudgment;
        this.isDerivable = isDerivable;
        this.premise1Rule = premise1Rule;
        this.premise2Rule = premise2Rule;
    }
}
