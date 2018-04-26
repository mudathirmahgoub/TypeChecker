package parser.syntaxtree;

import typechecker.Answer;
import typechecker.ApplicationRule;
import typechecker.LambdaRule;

public class Application extends Term
{
    public Term function;
    public Term argument;
    public Type annotation;

    @Override
    public Answer check(Type type, TypingContext typingContext)
    {
        // check premise1
        ArrowType arrowType = new ArrowType();
        arrowType.domain = annotation;
        arrowType.range = type;
        Answer premise1Answer = function.check(arrowType, typingContext);

        // check premise2
        Answer premise2Answer = argument.check(annotation, typingContext);

        Judgment judgment = new Judgment(typingContext, this, type);
        ApplicationRule rule = new ApplicationRule(judgment, premise1Answer, premise2Answer);
        Answer answer = new Answer(premise1Answer.isDerivable && premise2Answer.isDerivable, rule);
        return answer;
    }
}
