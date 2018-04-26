package parser.syntaxtree;

import typechecker.Answer;

public class Lambda extends Term
{
    public String variable;
    public Term term;

    @Override
    public Answer check(Type type, TypingContext typingContext)
    {
        throw new UnsupportedOperationException();
    }
}
