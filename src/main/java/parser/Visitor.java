package parser;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.antlr.SystemFBaseVisitor;
import parser.antlr.SystemFParser;

import java.util.ArrayList;
import java.util.List;

public class Visitor extends SystemFBaseVisitor<Object>
{
    @Override
    public Object visitSystemF(SystemFParser.SystemFContext ctx) {
        super.visitSystemF(ctx);
        return null;
    }
}
