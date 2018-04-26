package parser.syntaxtree;

public class ArrowType extends Type
{
    public Type domain;
    public Type range;

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
}
