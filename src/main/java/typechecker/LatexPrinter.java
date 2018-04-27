package typechecker;

import parser.syntaxtree.*;

import java.util.Map;

public class LatexPrinter
{

    private StringBuilder stringBuilder = new StringBuilder();

    String print(DerivationRule rule)
    {
        visit(rule);
        return "\\begin{prooftree}\n" +   stringBuilder + "\\end{prooftree}";
    }

    private void visit(DerivationRule rule)
    {
        if(rule instanceof  VariableRule)
        {
            visit((VariableRule)rule);
        }

        if(rule instanceof  ApplicationRule)
        {
            visit((ApplicationRule)rule);
        }

        if(rule instanceof  LambdaRule)
        {
            visit((LambdaRule)rule);
        }
    }

    private void visit(VariableRule rule)
    {
        String conclusionString = visit(rule.judgment);
        stringBuilder.append("\\AxiomC{} \\UnaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(ApplicationRule rule)
    {
        visit(rule.premise1Rule);

        visit(rule.premise2Rule);

        String conclusionString = visit(rule.judgment);

        stringBuilder.append("\\BinaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(LambdaRule rule)
    {
        visit(rule.premiseRule);

        String conclusionString = visit(rule.judgment);

        stringBuilder.append("\\UnaryInfC{$" + conclusionString + "$}\n");
    }

    private String visit(Judgment judgment)
    {
        String string = visit(judgment.typingContext) + " \\vdash " +
                visit(judgment.term) + " : " +
                visit(judgment.type);
        return string;
    }

    private String visit(TypingContext typingContext)
    {
        if(typingContext.context.size() == 0)
        {
            return "\\cdot";
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
        return "(" + visit(application.function) + "\\;"  +
                visit(application.argument) + ") [" +
                visit(application.annotation) + "]";
    }

    private String visit(Lambda lambda)
    {
        return  " \\lambda " + lambda.variable + ". " + visit(lambda.term);
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
        return "(" + visit(type.domain) + " \\rightarrow "  + visit(type.range) + ")";
    }

    private String visit(ForAllType type)
    {
        throw new UnsupportedOperationException(type.toString());
    }
}
