package typechecker;

import parser.syntaxtree.Judgment;
import parser.syntaxtree.Term;
import parser.syntaxtree.Type;
import parser.syntaxtree.TypingContext;

public class VariableRule extends DerivationRule
{
    Judgment judgment;
    public VariableRule(TypingContext typingContext, Term term, Type type)
    {
        judgment = new Judgment(typingContext, term, type);
    }
}
