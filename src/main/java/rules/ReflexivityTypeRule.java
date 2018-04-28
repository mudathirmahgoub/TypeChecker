package rules;

import parser.syntaxtree.BaseType;

public class ReflexivityTypeRule extends SubtypeRule
{
    BaseType baseType ;
    public ReflexivityTypeRule(BaseType baseType)
    {
        this.baseType = baseType;
    }
}
