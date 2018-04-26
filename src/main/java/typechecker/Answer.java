package typechecker;

public class Answer
{
    public boolean isDerivable;
    public DerivationTreeNode derivationTreeNode;
    public Answer(boolean isDerivable)
    {
        this.isDerivable = isDerivable;
    }
    public Answer(boolean isDerivable, DerivationTreeNode derivationTreeNode)
    {
        this(isDerivable);
        this.derivationTreeNode = derivationTreeNode;
    }

}
