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
        return rule.isDerivable + "\n" + string;
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

        if(rule instanceof  TransitivityTypeRule)
        {
            return visit((TransitivityTypeRule)rule, level);
        }

        if(rule instanceof  InvalidTypeRule)
        {
            return visit((InvalidTypeRule)rule, level);
        }

        if(rule instanceof  ArrowTypeRule)
        {
            return visit((ArrowTypeRule)rule, level);
        }

        if(rule instanceof  ReflexivityTypeRule)
        {
            return visit((ReflexivityTypeRule)rule, level);
        }

        if(rule instanceof  ForAllElimination)
        {
            return visit((ForAllElimination)rule, level);
        }

        if(rule instanceof  ForAllIntroduction)
        {
            return visit((ForAllIntroduction)rule, level);
        }

        if(rule instanceof  RenamingRule)
        {
            return visit((RenamingRule)rule, level);
        }

        return null;
    }

    private StringNode visit(RenamingRule rule, int level)
    {
        StringNode premiseNode =  visit(rule.premiseRule, level - 2);

        String conclusionString = visit(rule.judgment);

        int lineLength = Math.max(premiseNode.string.length(), conclusionString.length());

        String line = new String(new char[lineLength]).replace('\0', '-');

        StringNode lineNode = new StringNode(level-1, line +"(renaming)",
                Arrays.asList(premiseNode));

        StringNode node = new StringNode(level, conclusionString, Arrays.asList(lineNode));
        return node;
    }

    private StringNode visit(ForAllIntroduction rule, int level)
    {
        StringNode premiseNode =  visit(rule.premiseRule, level - 2);

        String conclusionString = visit(rule.judgment);

        int lineLength = Math.max(premiseNode.string.length(), conclusionString.length());

        String line = new String(new char[lineLength]).replace('\0', '-');

        StringNode lineNode = new StringNode(level-1, line +"(introduction)",
                Arrays.asList(premiseNode));

        StringNode node = new StringNode(level, conclusionString, Arrays.asList(lineNode));
        return node;
    }

    private StringNode visit(ForAllElimination rule, int level)
    {
        StringNode premiseNode =  visit(rule.premiseRule, level - 2);

        String conclusionString = visit(rule.judgment);

        int lineLength = Math.max(premiseNode.string.length(), conclusionString.length());

        String line = new String(new char[lineLength]).replace('\0', '-');

        StringNode lineNode = new StringNode(level-1, line +"(elimination)",
                Arrays.asList(premiseNode));

        StringNode node = new StringNode(level, conclusionString, Arrays.asList(lineNode));
        return node;
    }

    private StringNode visit(ReflexivityTypeRule rule, int level)
    {
        String conclusionString = visit(rule.subtypeJudgment) + "\t";

        String line = new String(new char[conclusionString.length()]).replace('\0', '-') + "(reflexive)\t";

        String premise = new String(new char[conclusionString.length()]).replace('\0', ' ') + "     \t";

        StringNode premiseNode = new StringNode(level -2, premise, new ArrayList<>());
        StringNode child = new StringNode(level-1, line, Arrays.asList(premiseNode));
        StringNode node = new StringNode(level, conclusionString, Arrays.asList(child));
        return  node;
    }

    private StringNode visit(ArrowTypeRule rule, int level)
    {
        StringNode premise1Node =  visit(rule.premise1Rule, level - 2);

        StringNode premise2Node =  visit(rule.premise2Rule, level - 2);

        String conclusionString = visit(rule.subtypeJudgment);

        int minSpaceLength = 4;

        int lineLength = Math.max(premise1Node.string.length() +
                        premise2Node.string.length() + minSpaceLength,
                conclusionString.length());

        String line = new String(new char[lineLength + 4]).replace('\0', '-');

        premise1Node.string += "\t\t";
        StringNode lineNode = new StringNode(level-1, line + "(arrow)",
                Arrays.asList(premise2Node, premise1Node));

        StringNode node = new StringNode(level, conclusionString, Arrays.asList(lineNode));
        return node;
    }

    private StringNode visit(InvalidTypeRule rule, int level)
    {
        StringNode premiseNode =  new StringNode(level -2, "false", new ArrayList<>());

        String conclusionString = visit(rule.subtypeJudgment);

        int lineLength = Math.max(premiseNode.string.length(), conclusionString.length());

        String line = new String(new char[lineLength]).replace('\0', '-');

        StringNode lineNode = new StringNode(level-1, line +"(\\invalid)",
                Arrays.asList(premiseNode));

        StringNode node = new StringNode(level, conclusionString, Arrays.asList(lineNode));
        return node;
    }

    private StringNode visit(TransitivityTypeRule rule, int level)
    {
        StringNode premise1Node =  visit(rule.premise1Rule, level - 2);

        StringNode premise2Node =  visit(rule.premise2Rule, level - 2);

        String conclusionString = visit(rule.subtypeJudgment);

        int minSpaceLength = 4;

        int lineLength = Math.max(premise1Node.string.length() +
                        premise2Node.string.length() + minSpaceLength,
                conclusionString.length());

        String line = new String(new char[lineLength + 4]).replace('\0', '-');

        premise1Node.string += "\t\t";
        StringNode lineNode = new StringNode(level-1, line + "(transitive)",
                Arrays.asList(premise2Node, premise1Node));

        StringNode node = new StringNode(level, conclusionString, Arrays.asList(lineNode));
        return node;
    }

    private StringNode visit(VariableRule rule, int level)
    {
        String conclusionString = visit(rule.judgment) + "\t";

        String ruleName = "";
        if(rule.isDerivable == DerivationAnswer.Yes)
        {
            ruleName = "(var)\t";
        }
        else
        {
            if (rule.isDerivable == DerivationAnswer.No)
            {
                ruleName = "(invalid var)\t";
            } else
            {
                ruleName = "(unknown)\t";
            }
        }
        String line = new String(new char[conclusionString.length()]).replace('\0', '-') + ruleName;

        String premise = new String(new char[conclusionString.length()]).replace('\0', ' ') + "     \t";

        StringNode premiseNode = new StringNode(level -2, premise, new ArrayList<>());
        StringNode child = new StringNode(level-1, line, Arrays.asList(premiseNode));
        StringNode node = new StringNode(level, conclusionString, Arrays.asList(child));
        return  node;
    }

    private StringNode visit(ApplicationRule rule, int level)
    {
        StringNode premise1Node =  visit(rule.premise1Rule, level - 2);

        StringNode premise2Node =  visit(rule.premise2Rule, level - 2);

        String conclusionString = visit(rule.judgment);

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

        String conclusionString = visit(rule.judgment);

        int lineLength = Math.max(premiseNode.string.length(), conclusionString.length());

        String line = new String(new char[lineLength]).replace('\0', '-');

        StringNode lineNode = new StringNode(level-1, line +"(\\lambda)",
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

        String conclusionString = visit(rule.judgment);

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

    private String visit(SubtypeJudgment judgment)
    {
        String string = visit(judgment.subType) + " <: " +
                visit(judgment.superType);
        return string;
    }

    private String visit(Judgment judgment)
    {
          String string = visit(judgment.typingContext) + " |- " +
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

    private String visit(Variable term)
    {
        return  term.name +
                (term.eliminationAnnotation == null? "":
                        "[[" + visit(term.eliminationAnnotation) + "]]");
    }

    private String visit(Application application)
    {
        return "(" + visit(application.function) + " "  +
                visit(application.argument) + ") [" +
                visit(application.annotation) + "]";
    }

    private String visit(Lambda lambda)
    {
        return  "\\lambda" + lambda.variable + ". " + visit(lambda.term);
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
        return "(" + visit(type.domain) + " -> "  + visit(type.range) + ")";
    }

    private String visit(ForAllType type)
    {
        return "\\forall " + type.typeVariableName + "." + visit(type.type);
    }
}
