package typechecker;

import parser.syntaxtree.BaseType;

public class ReflexivityTypeRule extends DerivationRule
{
    BaseType baseType ;
    public ReflexivityTypeRule(BaseType baseType)
    {
        this.baseType = baseType;
    }
}
