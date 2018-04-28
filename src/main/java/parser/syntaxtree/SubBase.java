package parser.syntaxtree;

public class SubBase extends SystemFNode
{
    public String subType ;
    public String superType;
    public SubBase(String subType, String superType)
    {
        this.subType = subType;
        this.superType = superType;
    }
}
