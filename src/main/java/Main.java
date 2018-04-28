import org.apache.commons.cli.*;
import rules.DefaultPrinter;
import rules.DerivationRule;
import rules.LatexPrinter;
import rules.TypeChecker;

import java.io.File;

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
                if(command.hasOption("l"))
                {
                    LatexPrinter printer = new LatexPrinter();
                    System.out.println(printer.print(derivationRule));
                }
                else
                {
                    DefaultPrinter printer = new DefaultPrinter();
                    System.out.println(printer.print(derivationRule));
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
            formatter.printHelp( "java -jar TypeChecker.jar ", options );
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
