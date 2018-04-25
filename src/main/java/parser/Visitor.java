package parser;

import parser.antlr.SystemFBaseVisitor;
import parser.antlr.SystemFParser;
import parser.syntaxtree.SystemFSyntaxTree;

public class Visitor extends SystemFBaseVisitor<SystemFSyntaxTree>
{
    @Override
    public SystemFSyntaxTree visitSystemF(SystemFParser.SystemFContext ctx) {
        super.visitSystemF(ctx);
        return null;
    }

    @Override
    public SystemFSyntaxTree visitJudgment(SystemFParser.JudgmentContext ctx) {
        return super.visitJudgment(ctx);
    }
}
