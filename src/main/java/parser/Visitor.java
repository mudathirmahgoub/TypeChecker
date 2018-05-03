package parser;

import org.antlr.v4.runtime.tree.TerminalNode;
import parser.antlr.SystemFBaseVisitor;
import parser.antlr.SystemFParser;
import parser.syntaxtree.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Visitor extends SystemFBaseVisitor<SystemFNode>
{
    @Override
    public SystemFNode visitSystemF(SystemFParser.SystemFContext ctx)
    {
        Program program = new Program();

        program.subBases = new ArrayList<>();

        List<SystemFParser.SubtypeContext> subtypes =  ctx.subtype();

        // add subBases
        for(SystemFParser.SubtypeContext context : subtypes)
        {
            SubBase subBase = (SubBase) this.visitSubtype(context);
            program.subBases.add(subBase);
            if(SystemFNode.subTypes.containsKey(subBase.subType))
            {
              List<String> superTypes = SystemFNode.subTypes.get(subBase.subType);
              superTypes.add(subBase.superType);
              SystemFNode.subTypes.put(subBase.subType, superTypes);
            }
            else
            {
                SystemFNode.subTypes.put(subBase.subType, Arrays.asList(subBase.superType));
            }

        }

        // add judgment

        program.judgment = (Judgment) this.visitJudgment(ctx.judgment());

        return program;
    }

    @Override
    public SystemFNode visitSubtype(SystemFParser.SubtypeContext ctx)
    {

        String subType = ctx.Identifier().get(0).getText();
        String superType = ctx.Identifier().get(1).getText();
        return new SubBase(subType, superType);
    }

    @Override
    public SystemFNode visitJudgment(SystemFParser.JudgmentContext ctx)
    {
       TypingContext typingContext = (TypingContext)
               this.visitTypingContext(ctx.typingContext());
       Term term = (Term) this.visitTerm(ctx.term());
       Type type = (Type) this.visitType(ctx.type());

       return new Judgment(typingContext, term, type);
    }

    @Override
    public SystemFNode visitTypingContext(SystemFParser.TypingContextContext ctx)
    {
        TypingContext typingContext = new TypingContext();

        List<TerminalNode> identifiers =  ctx.Identifier();

        List<SystemFParser.TypeContext> types = ctx.type();

        for(int i = 0 ; i < identifiers.size(); i++)
        {
            Type type = (Type) this.visitType(types.get(i));
            typingContext.context.put(identifiers.get(i).getText(), type);
        }

        return typingContext;
    }

    @Override
    public SystemFNode visitType(SystemFParser.TypeContext ctx)
    {
        Type type = null;

        if(ctx.variableType() != null)
        {
            type = (Type) this.visitVariableType(ctx.variableType());
        }

        if(ctx.forAllType() != null)
        {
            type = (Type) this.visitForAllType(ctx.forAllType());
        }

        // handle the parenthesis case
        if(ctx.type() != null)
        {
            type = (Type) this.visitType(ctx.type());
        }

        if(ctx.arrowType() != null)
        {
            ArrowType arrowType = (ArrowType) this.visitArrowType(ctx.arrowType());
            arrowType.domain = type;
            type = arrowType;
        }
        return type;
    }

    @Override public SystemFNode visitVariableType(SystemFParser.VariableTypeContext ctx)
    {
        String name = ctx.Identifier().getText();
        SystemFNode.variableTypeNames.add(name);
        return new VariableType(name);
    }

    @Override
    public SystemFNode visitArrowType(SystemFParser.ArrowTypeContext ctx)
    {
        Type type = (Type) this.visitType(ctx.type());
        ArrowType arrowType = new ArrowType();
        arrowType.range = type;
        return arrowType;
    }

    @Override
    public SystemFNode visitForAllType(SystemFParser.ForAllTypeContext ctx)
    {
        ForAllType forAllType = new ForAllType();
        forAllType.typeVariableName = ctx.Identifier().getText();
        forAllType.type = (Type) this.visitType(ctx.type());
        return forAllType;
    }

    @Override
    public SystemFNode visitTerm(SystemFParser.TermContext ctx)
    {
        Term term = null;
        if(ctx.variable() != null)
        {
            term = (Term) this.visitVariable(ctx.variable());
        }

        if(ctx.application() != null)
        {
            term = (Term) this.visitApplication(ctx.application());
        }

        if(ctx.lambda() != null)
        {
            term = (Term) this.visitLambda(ctx.lambda());
        }

        if(ctx.typeApplication() != null)
        {
            Type type = (Type) this.visitTypeApplication(ctx.typeApplication());
            term.eliminationAnnotation = type;
        }
        return term;
    }

    @Override
    public SystemFNode visitVariable(SystemFParser.VariableContext ctx)
    {
        Variable variable = new Variable(ctx.Identifier().getText());
        return variable;
    }

    @Override
    public SystemFNode visitLambda(SystemFParser.LambdaContext ctx)
    {
        Lambda lambda = new Lambda();
        lambda.variable = ctx.Identifier().getText();
        lambda.term = (Term) this.visitTerm(ctx.term());
        return lambda;
    }

    @Override
    public SystemFNode visitApplication(SystemFParser.ApplicationContext ctx)
    {
        Application application = new Application();
        application.function = (Term) this.visitTerm(ctx.term().get(0));
        application.argument = (Term) this.visitTerm(ctx.term().get(1));
        application.annotation = (Type) this.visitType(ctx.type());

        return application;
    }

    @Override
    public SystemFNode visitTypeApplication(SystemFParser.TypeApplicationContext ctx)
    {
        return this.visitType(ctx.type());
    }
}
