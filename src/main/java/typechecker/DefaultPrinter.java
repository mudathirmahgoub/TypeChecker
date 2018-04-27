package typechecker;

import parser.syntaxtree.*;

import java.util.Map;

public class DefaultPrinter
{
    String print(DerivationRule rule)
    {
        return visit(rule);
    }

    private String visit(DerivationRule rule)
    {
        if(rule instanceof  VariableRule)
        {
            return visit((VariableRule)rule);
        }

        if(rule instanceof  ApplicationRule)
        {
            return visit((ApplicationRule)rule);
        }

        if(rule instanceof  LambdaRule)
        {
            return visit((LambdaRule)rule);
        }

        return null;
    }

    private String visit(VariableRule rule)
    {
        String conclusionString = visit(rule.judgment);

        String line = new String(new char[conclusionString.length()]).replace('\0', '-');

        return line + "(var)" + "\n" + conclusionString;
    }

    private String visit(ApplicationRule rule)
    {
        String premise1String =  visit(rule.premise1Rule);

        String premise2String =  visit(rule.premise2Rule);

        String conclusionString = rule.judgment.toString();

        int minSpaceLength = 4;

        int lineLength = Math.max(premise1String.length() + premise1String.length() + minSpaceLength,
                conclusionString.length());

        int spaceLength = Math.max(minSpaceLength,
                lineLength - (premise1String.length() + premise1String.length()));

        String line = new String(new char[lineLength]).replace('\0', '-');
        String space= new String(new char[spaceLength]).replace('\0', ' ');

        return premise1String + space + premise2String + "\n" + line + "(app)" +"\n" + conclusionString;
    }

    private String visit(LambdaRule rule)
    {
        String premiseString =  visit(rule.premiseRule);

        String conclusionString = rule.judgment.toString();

        int lineLength = Math.max(premiseString.length(), conclusionString.length());

        String line = new String(new char[lineLength]).replace('\0', '-');

        return premiseString + "\n" + line +"(λ)"+ "\n" + conclusionString;
    }

    private String visit(Judgment judgment)
    {
          String string = visit(judgment.typingContext) + " ⊢ " +
                          visit(judgment.term) + " : " +
                          visit(judgment.type);
          return string;
    }

    private String visit(TypingContext typingContext)
    {
        if(typingContext.context.size() == 0)
        {
            return "·";
        }
        else
        {
            StringBuilder builder  = new StringBuilder();

            for(Map.Entry<String, Type> entry : typingContext.context.entrySet())
            {
                builder.append(entry.getKey() + ": " + visit(entry.getValue()) + ", ");
            }

            String contextString = builder.toString();
            // remove the last comma
            contextString = contextString.substring(0, contextString.length() - 2);

            return contextString;
        }
    }

    private String visit(Term term)
    {
        if(term instanceof Variable)
        {
            return visit((Variable)term);
        }

        if(term instanceof  Application)
        {
            return visit((Application)term);
        }

        if(term instanceof  Lambda)
        {
            return visit((Lambda)term);
        }

        return null;
    }

    private String visit(Variable variable)
    {
        return  variable.name;
    }

    private String visit(Application application)
    {
        return "(" + visit(application.function) + " "  +
                visit(application.argument) + ") [" +
                visit(application.annotation) + "]";
    }

    private String visit(Lambda lambda)
    {
        return  "λ" + lambda.variable + ". " + visit(lambda.term);
    }

    private String visit(Type type)
    {
        if(type instanceof BaseType)
        {
            return visit((BaseType)type);
        }

        if(type instanceof  ArrowType)
        {
            return visit((ArrowType)type);
        }

        if(type instanceof  ForAllType)
        {
            return visit((ForAllType)type);
        }

        return null;
    }

    private String visit(BaseType type)
    {
        return type.name;
    }

    private String visit(ArrowType type)
    {
        return "(" + visit(type.domain) + " → "  + visit(type.range) + ")";
    }

    private String visit(ForAllType type)
    {
        throw new UnsupportedOperationException(type.toString());
    }
}
