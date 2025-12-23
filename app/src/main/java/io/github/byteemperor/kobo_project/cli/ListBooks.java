package io.github.byteemperor.kobo_project.cli;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.ParentCommand;
import picocli.CommandLine.Option;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Command(
        name = "list",
        description = "List all books on the kobo reader"
)

public class ListBooks implements Runnable {

    @ParentCommand
    KoboCtlCommand parent;

    @Override
    public void run() {

        Path dbPath = parent.databasePath;

        System.out.println("Using database: " + dbPath.toAbsolutePath());

        String url = "jdbc:sqlite:" + dbPath.toAbsolutePath();

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT BookTitle FROM content"
             )
        )  {

            while (rs.next()) {
                System.out.println(rs.getString("BookTitle"));
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to read Kobo database", e);
        }

    }

}
