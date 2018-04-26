package parser.syntaxtree;

public class BaseType extends Type
{
    public String name;

    @Override
    public boolean equals(Object object)
    {
        if(object.getClass() != BaseType.class)
        {
            return false;
        }
        BaseType type = (BaseType) object;

        return type.name.equals(this.name);
    }

    @Override
    public String toString()
    {
        return name;
    }
}
