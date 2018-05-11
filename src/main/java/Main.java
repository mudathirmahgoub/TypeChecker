import org.apache.commons.cli.*;
import printers.DefaultPrinter;
import rules.DerivationRule;
import printers.LatexPrinter;
import typechecker.TypeChecker;

import java.io.File;
import java.util.Formatter;

public class Main
{

    public static void main(String[] args)
    {
        Options options = new Options();

        options.addOption(Option.builder("i").longOpt("input").hasArg().required().build());

        options.addOption(Option.builder("l").longOpt("latex").build());
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
                DerivationRule derivationRule = typeChecker.check();
                String result ;
                if(command.hasOption("l"))
                {
                    LatexPrinter printer = new LatexPrinter();
                    result = printer.print(derivationRule);
                    System.out.println(result);
                }
                else
                {
                    DefaultPrinter printer = new DefaultPrinter();
                    result = printer.print(derivationRule);
                    System.out.println(result);
                }

                if(command.hasOption("o"))
                {
                    File outputFile = new File(command.getOptionValue("o"));
                    Formatter formatter = new Formatter(outputFile);
                    formatter.format("%s", result);
                    formatter.close();
                }
            }
            else
            {
                throw new ParseException("");
            }
        }
        catch (ParseException exception)
        {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "java -jar typechecker.TypeChecker.jar ", options );
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
