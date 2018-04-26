package parser.syntaxtree;

import typechecker.Answer;
import typechecker.DerivationRule;
import typechecker.LambdaRule;

import java.util.HashMap;

public class Lambda extends Term
{
    public String variable;
    public Term term;

    @Override
    public Answer check(Type type, TypingContext typingContext)
    {

        // for a lambda term, the type should be an arrow type
        if(ArrowType.class != type.getClass())
        {
            return new Answer(false);
        }

        ArrowType arrowType = (ArrowType) type;

        TypingContext premiseTypingContext = new TypingContext(typingContext);

        // add the variable and the domain type to context
        premiseTypingContext.context.put(variable, arrowType.domain);

        // check the premiseAnswer rule
        Answer premiseAnswer = term.check(arrowType.range, premiseTypingContext);

        Judgment judgment = new Judgment(typingContext, this, type);
        LambdaRule rule = new LambdaRule(judgment, premiseAnswer);
        Answer answer = new Answer(premiseAnswer.isDerivable, rule);
        return answer;
    }
}
