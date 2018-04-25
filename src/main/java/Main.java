import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.cli.*;
import parser.Visitor;
import typechecker.Answer;
import typechecker.TypeChecker;
import parser.antlr.SystemFLexer;
import parser.antlr.SystemFParser;
import parser.syntaxtree.SystemFSyntaxTree;

import java.io.File;
import java.nio.charset.Charset;

public class Main
{

    public static void main(String[] args)
    {
        Options options = new Options();

        options.addOption(Option.builder("i").longOpt("input").hasArg().required().build());
        options.addOption(Option.builder("o").longOpt("output").hasArg().build());

        CommandLineParser commandLineParser = new DefaultParser();
        try
        {
            CommandLine command = commandLineParser.parse(options, args);
            if (command.hasOption("i"))
            {
                String inputFile  = command.getOptionValue("i");
                File file = new File(inputFile);
                TypeChecker typeChecker = new TypeChecker(file);
                Answer answer = typeChecker.check();
                System.out.println(answer);
            }
            else
            {
                throw new ParseException("");
            }
        }
        catch (ParseException exception)
        {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "java -jar TypeChecker.jar ", options );
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
