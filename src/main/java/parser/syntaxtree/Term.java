package parser.syntaxtree;
import rules.DerivationRule;

abstract public class Term extends SystemFNode
{
    public abstract DerivationRule check(Type type, TypingContext typingContext);
    public Type eliminationAnnotation;
}
