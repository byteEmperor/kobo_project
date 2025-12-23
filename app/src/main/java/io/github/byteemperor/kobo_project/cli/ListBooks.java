package io.github.byteemperor.kobo_project.cli;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.ParentCommand;
import picocli.CommandLine.Option;

@Command(
        name = "list",
        description = "List all books on the kobo reader"
)

public class ListBooks implements Runnable {

    @ParentCommand
    KoboCtlCommand parent;

    @Override
    public void run() {
        System.out.println("List command is running");
        if (parent.verbose) {
            System.out.println("Verbose mode enabled");
        }
    }

}
