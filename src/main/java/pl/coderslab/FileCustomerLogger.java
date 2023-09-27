package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class FileCustomerLogger implements CustomerLogger {


    private String fileName;

    @Override
    public void log() {
        Path filePath = Paths.get(fileName);
        try {
            List<String> lines = Files.exists(filePath) ? Files.readAllLines(filePath, StandardCharsets.UTF_8) : new ArrayList<>();
            lines.add(String.valueOf(LocalDateTime.now()));
            Files.write(filePath, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Autowired()
    public FileCustomerLogger(@Value(value = "log.txt") String fileName) {
        this.fileName = fileName;
    }

}
