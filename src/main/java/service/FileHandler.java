package service;

import java.io.IOException;

public interface FileHandler {

    void writeFile() throws IOException;
    String readFile() throws IOException;
}
