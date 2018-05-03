package rules;

import parser.syntaxtree.Type;

public class ReflexivityTypeRule extends SubtypeRule
{
    Type type ;

    public ReflexivityTypeRule(Type type)
    {
        this.type = type;
        this.isDerivable = DerivationAnswer.Yes;
        this.subtypeJudgment = new SubtypeJudgment(type, type);
    }
}
