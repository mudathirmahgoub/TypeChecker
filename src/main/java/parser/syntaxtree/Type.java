package parser.syntaxtree;

public abstract class Type extends SystemFNode
{
    abstract public boolean isFreeType(String name);

    protected abstract Type rename(String oldName, String newName);
}
