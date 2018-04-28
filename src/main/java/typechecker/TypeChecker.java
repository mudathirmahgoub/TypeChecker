package typechecker;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.Visitor;
import parser.antlr.SystemFLexer;
import parser.antlr.SystemFParser;
import parser.syntaxtree.Program;
import parser.syntaxtree.SystemFNode;
import rules.DerivationRule;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class TypeChecker
{
    private Program program;
    public TypeChecker(File file) throws IOException
    {
        CharStream charStream = CharStreams.fromFileName(file.getAbsolutePath(),
                Charset.forName("windows-1252"));
        parseProgram(charStream);
    }

    public TypeChecker(String program)
    {
        CharStream charStream = CharStreams.fromString(program);
        parseProgram(charStream);
    }

    private void parseProgram(CharStream charStream)
    {
        SystemFLexer lexer = new SystemFLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SystemFParser parser = new SystemFParser(tokenStream);

        ParseTree tree =  parser.systemF();
        Visitor visitor = new Visitor();
        this.program = (Program) visitor.visit(tree);
    }

    public DerivationRule check()
    {
        return this.program.check();
    }

    public SystemFNode getProgram()
    {
        return program;
    }
}
