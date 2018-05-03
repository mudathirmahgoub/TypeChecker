package parser.syntaxtree;

public class ForAllType extends Type
{
    public String typeVariableName;
    public Type type;

    public ForAllType() {}

    public ForAllType(String typeVariableName, Type type)
    {
        this.typeVariableName = typeVariableName;
        this.type = type;
    }

    @Override
    public boolean isFreeType(String name)
    {
        if(typeVariableName.equals(name))
        {
            return false;
        }
        return type.isFreeType(name);
    }

    @Override
    public boolean equals(Object object)
    {
        if(object.getClass() != ForAllType.class)
        {
            return false;
        }

        ForAllType forAllType = (ForAllType) object;

        // type variable name shouldn't not be free
        if(isFreeType(forAllType.typeVariableName))
        {
            return false;
        }

        ForAllType renamedType = this.rename(forAllType.typeVariableName);

        return renamedType.type.equals(forAllType.type);
    }

    @Override
    public String toString()
    {
        return "∀" + this.typeVariableName + ". " + this.type;
    }

    public ForAllType rename(String name)
    {
        if(isFreeType(name))
        {
            throw new UnsupportedOperationException(name +" is free in " + this.toString());
        }
        ForAllType forAllType = new ForAllType();
        forAllType.typeVariableName = name;
        forAllType.type = this.type.rename(this.typeVariableName, name);
        return forAllType;
    }

    @Override
    protected Type rename(String oldName, String newName)
    {
        // if there is a conflict
        if(this.typeVariableName.equals(newName))
        {
            // rename the type variable
            String variableTypeName = SystemFNode.getNewVariableTypeName();
            ForAllType renamedType = this.rename(variableTypeName);
            renamedType.type = renamedType.type.rename(oldName, newName);
            return renamedType;
        }

        Type newType = this.type.rename(oldName, newName);
        ForAllType renamedType = new ForAllType(this.typeVariableName, newType);
        return renamedType;
    }
}
