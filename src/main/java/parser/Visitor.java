package parser;

import org.antlr.v4.runtime.tree.TerminalNode;
import parser.antlr.SystemFBaseVisitor;
import parser.antlr.SystemFParser;
import parser.syntaxtree.*;

import java.util.ArrayList;
import java.util.List;

public class Visitor extends SystemFBaseVisitor<SystemFSyntaxTree>
{
    @Override
    public SystemFSyntaxTree visitSystemF(SystemFParser.SystemFContext ctx)
    {
        Program program = new Program();

        program.subBases = new ArrayList<>();

        List<SystemFParser.SubtypeContext> subtypes =  ctx.subtype();

        // add subBases
        for(SystemFParser.SubtypeContext context : subtypes)
        {
            SubBase subBase = (SubBase) this.visitSubtype(context);
            program.subBases.add(subBase);
        }

        // add judgment

        program.judgment = (Judgment) this.visitJudgment(ctx.judgment());

        return program;
    }

    @Override
    public SystemFSyntaxTree visitJudgment(SystemFParser.JudgmentContext ctx)
    {
       Judgment judgment = new Judgment();
       judgment.typingContext = (TypingContext)
               this.visitTypingContext(ctx.typingContext());
       judgment.term = (Term) this.visitTerm(ctx.term());
       judgment.type = (Type) this.visitType(ctx.type());

       return judgment;
    }

    @Override
    public SystemFSyntaxTree visitTypingContext(SystemFParser.TypingContextContext ctx)
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
    public SystemFSyntaxTree visitTerm(SystemFParser.TermContext ctx)
    {
        return super.visitTerm(ctx);
    }

    @Override
    public SystemFSyntaxTree visitVariable(SystemFParser.VariableContext ctx)
    {
        Variable variable = new Variable(ctx.getChild(0).getText());
        return variable;
    }
}
