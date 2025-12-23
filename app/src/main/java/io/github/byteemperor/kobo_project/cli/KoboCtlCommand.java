package io.github.byteemperor.kobo_project.cli;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.nio.file.Path;

@Command(
        name = "koboctl",
        description = "Command-line tool to manage Kobo eBook readers",
        mixinStandardHelpOptions = true,
        subcommands = {
                ListBooks.class
        }
)

public class KoboCtlCommand {

    @Option(
            names = {"-v", "--verbose"},
            description = "Enable verbose output",
            scope = CommandLine.ScopeType.INHERIT
    )

    boolean verbose;

    @Option(
            names = {"-d", "--db"},
            description = "Path to Kobo SQLite database",
            defaultValue = "../dev/KoboReader.sqlite"
    )

    Path databasePath;

}


