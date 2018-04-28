package parser.syntaxtree;

import rules.DerivationRule;

public class Judgment extends SystemFNode
{
    public TypingContext typingContext;
    public Term term;
    public Type type;

    public Judgment(TypingContext typingContext, Term term, Type type)
    {
        this.typingContext = typingContext;
        this.term = term;
        this.type = type;
    }

    public DerivationRule check()
    {
        return term.check(type, typingContext);
    }

    @Override
    public String toString()
    {
        return  typingContext + " ⊢ " + term + " : " + type;
    }
}
