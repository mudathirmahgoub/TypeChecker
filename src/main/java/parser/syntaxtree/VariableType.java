package parser.syntaxtree;

public class VariableType extends Type
{
    public String name;

    public VariableType(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object object)
    {
        if(object.getClass() != VariableType.class)
        {
            return false;
        }
        VariableType type = (VariableType) object;

        return type.name.equals(this.name);
    }

    @Override
    public String toString()
    {
        return name;
    }

    @Override
    public boolean isFreeType(String name)
    {
        return this.name.equals(name);
    }

    @Override
    protected Type rename(String oldName, String newName)
    {
        if(this.name.equals(oldName))
        {
            return new VariableType(newName);
        }

        return new VariableType(this.name);
    }
}
