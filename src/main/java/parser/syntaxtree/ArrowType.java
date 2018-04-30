package parser.syntaxtree;

public class ArrowType extends Type
{
    public Type domain;
    public Type range;

    public ArrowType(){}

    public ArrowType(Type domain, Type range)
    {
        this.domain = domain;
        this.range = range;
    }

    @Override
    public boolean equals(Object object)
    {
        if(object.getClass() != ArrowType.class)
        {
            return false;
        }
        ArrowType type = (ArrowType) object;

        return type.domain.equals(this.domain) &&
                type.range.equals(this.range) ;
    }

    @Override
    public String toString()
    {
        return "(" + domain + " → "  + range + ")";
    }

    @Override
    public boolean isFreeType(String name)
    {
        return domain.isFreeType(name) || range.isFreeType(name);
    }

    @Override
    protected Type rename(String oldName, String newName)
    {
        Type newDomain = this.domain.rename(oldName, newName);
        Type newRange = this.range.rename(oldName, newName);
        return new ArrowType(newDomain, newRange);
    }
}
