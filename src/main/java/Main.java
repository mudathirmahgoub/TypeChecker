import org.apache.commons.cli.*;

public class Main
{

    public static void main(String[] args)
    {
        Options options = new Options();

        options.addOption(Option.builder("i").longOpt("input").hasArg().required().build());
        options.addOption(Option.builder("o").longOpt("output").hasArg().build());

        CommandLineParser commandLineParser = new DefaultParser();
        try {
            CommandLine command = commandLineParser.parse(options, args);
            String inputFile  = command.getOptionValue("i");
            if (command.hasOption("i"))
            {

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
    }
}
