package service.writer;

import java.io.IOException;

public interface Recorder {

    void writeInFile(String htmlText) throws IOException;
}
