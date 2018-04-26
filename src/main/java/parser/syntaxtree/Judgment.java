package parser.syntaxtree;

import typechecker.Answer;

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

    public Answer check()
    {
        return term.check(type, typingContext);
    }
}
