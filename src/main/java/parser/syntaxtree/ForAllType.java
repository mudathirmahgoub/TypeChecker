package parser.syntaxtree;

public class ForAllType extends Type
{
    public String typeVariable;
    public Type type;

    @Override
    public boolean isFreeType(String name)
    {
        if(typeVariable.equals(name))
        {
            return false;
        }
        return type.isFreeType(name);
    }
}
