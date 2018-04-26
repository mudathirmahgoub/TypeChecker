package typechecker;

public class Answer
{
    public boolean isDerivable;
    public DerivationRule rule;
    public Answer(boolean isDerivable)
    {
        this.isDerivable = isDerivable;
    }
    public Answer(boolean isDerivable, DerivationRule rule)
    {
        this(isDerivable);
        this.rule = rule;
    }
}
