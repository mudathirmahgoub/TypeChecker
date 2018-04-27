package parser.syntaxtree;
import typechecker.DerivationRule;

abstract public class Term extends SystemFNode
{
    public abstract DerivationRule check(Type type, TypingContext typingContext);
}
