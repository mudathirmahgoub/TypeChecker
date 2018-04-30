package printers;

import parser.syntaxtree.*;
import rules.*;

import java.util.*;


public class DefaultPrinter extends AbstractPrinter
{
    private class StringNode
    {
        int level;
        String string;
        List<StringNode> children;
        StringNode(int level, String string, List<StringNode> children )
        {
            this.level = level;
            this.string = string;
            this.children = children;
        }
    }

    @Override
    public String print(DerivationRule rule)
    {
        StringNode root =  visit(rule, 0);
        LinkedList<StringNode> queue = new LinkedList<>();

        String string = "";
        StringBuilder builder = new StringBuilder();

        queue.add(root);
        int level = 0;
        // bfs
        while(! queue.isEmpty())
        {
            StringNode node = queue.poll();
            if(node.level < level)
            {
                string = "\n" + string;
                level = node.level;
            }
            string =  node.string + string;
            queue.addAll(node.children);
        }
        return string;
    }

    private StringNode visit(DerivationRule rule, int level)
    {
        if(rule instanceof VariableRule)
        {
            return visit((VariableRule)rule, level);
        }

        if(rule instanceof ApplicationRule)
        {
            return visit((ApplicationRule)rule, level);
        }

        if(rule instanceof LambdaRule)
        {
            return visit((LambdaRule)rule, level);
        }

        if(rule instanceof SubsumptionRule)
        {
            return visit((SubsumptionRule)rule, level);
        }

        if(rule instanceof  SubBaseRule)
        {
            return visit((SubBaseRule)rule, level);
        }

        return null;
    }

    private StringNode visit(VariableRule rule, int level)
    {
        String conclusionString = visit(rule.judgment) + "\t";

        String line = new String(new char[conclusionString.length()]).replace('\0', '-') + "(var)\t";

        StringNode child = new StringNode(level-1, line, new ArrayList<>());
        StringNode node = new StringNode(level, conclusionString, Arrays.asList(child));
        return  node;
    }

    private StringNode visit(ApplicationRule rule, int level)
    {
        StringNode premise1Node =  visit(rule.premise1Rule, level - 2);

        StringNode premise2Node =  visit(rule.premise2Rule, level - 2);

        String conclusionString = rule.judgment.toString();

        int minSpaceLength = 4;

        int lineLength = Math.max(premise1Node.string.length() +
                        premise2Node.string.length() + minSpaceLength,
                conclusionString.length());

        String line = new String(new char[lineLength + 4]).replace('\0', '-');

        premise1Node.string += "\t\t";
        StringNode lineNode = new StringNode(level-1, line + "(app)",
                Arrays.asList(premise2Node, premise1Node));

        StringNode node = new StringNode(level, conclusionString, Arrays.asList(lineNode));
        return node;
    }

    private StringNode visit(LambdaRule rule, int level)
    {
        StringNode premiseNode =  visit(rule.premiseRule, level - 2);

        String conclusionString = rule.judgment.toString();

        int lineLength = Math.max(premiseNode.string.length(), conclusionString.length());

        String line = new String(new char[lineLength]).replace('\0', '-');

        StringNode lineNode = new StringNode(level-1, line +"(λ)",
                Arrays.asList(premiseNode));

        StringNode node = new StringNode(level, conclusionString, Arrays.asList(lineNode));
        return node;
    }


    private StringNode visit(SubBaseRule rule, int level)
    {
        //ToDo: fix when only subase in a line
        String premiseString =  "SubBase(" + rule.subBase.subType + ", " +
                rule.subBase.superType + ")\t";
        String conclusionString = rule.subBase.subType + " <: " + rule.subBase.superType;
        int length = Math.max(premiseString.length(), conclusionString.length() );

        String line = new String(new char[length]).replace('\0', '-') + "(subBase)\t";

        StringNode premise = new StringNode(level -2, premiseString,
                new ArrayList<>());
        StringNode child = new StringNode(level-1, line, Arrays.asList(premise));
        StringNode node = new StringNode(level, conclusionString, Arrays.asList(child));
        return  node;
    }


    private StringNode visit(SubsumptionRule rule, int level)
    {
        StringNode premise1Node =  visit(rule.premise1Rule, level - 2);

        StringNode premise2Node =  visit(rule.premise2Rule, level - 2);

        String conclusionString = rule.judgment.toString();

        int minSpaceLength = 4;

        int lineLength = Math.max(premise1Node.string.length() +
                        premise2Node.string.length() + minSpaceLength,
                conclusionString.length());

        String line = new String(new char[lineLength + 4]).replace('\0', '-');

        premise1Node.string += "\t\t";
        StringNode lineNode = new StringNode(level-1, line + "(subsumption)",
                Arrays.asList(premise2Node, premise1Node));

        StringNode node = new StringNode(level, conclusionString, Arrays.asList(lineNode));
        return node;
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
        if(type instanceof VariableType)
        {
            return visit((VariableType)type);
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

    private String visit(VariableType type)
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
