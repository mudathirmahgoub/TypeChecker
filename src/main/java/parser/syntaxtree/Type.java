package parser.syntaxtree;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.Visitor;
import parser.antlr.SystemFLexer;
import parser.antlr.SystemFParser;

import java.io.UnsupportedEncodingException;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

public abstract class Type extends SystemFNode
{
    abstract public boolean isFreeType(String name);

    protected abstract Type rename(String oldName, String newName);


    public static Type replace(Type type, Type eliminationAnnotation, String typeVariableName)
    {
        String typeString = type.toString();
        String oldString = eliminationAnnotation.toString();
        String newString = typeString.replace(oldString, typeVariableName);
        CharStream charStream = CharStreams.fromString(newString);

        SystemFLexer lexer = new SystemFLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SystemFParser parser = new SystemFParser(tokenStream);

        Visitor visitor = new Visitor();
        Type newType = (Type) visitor.visitType(parser.type());
        return newType;
    }
}
