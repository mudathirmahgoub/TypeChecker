package rules;

import parser.syntaxtree.Type;

public class SubtypeJudgment
{
    public Type subType ;
    public Type superType;
    public SubtypeJudgment(Type subType, Type superType)
    {
        this.subType = subType;
        this.superType = superType;
    }
}
