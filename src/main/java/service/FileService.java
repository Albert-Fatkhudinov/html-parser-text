package service;

import service.reader.ReaderFile;
import service.writer.Recorder;

import java.io.IOException;

public class FileService implements FileHandler{

    private final ReaderFile readerFile;
    private final Recorder recorder;
    private final String htmlString;

    public FileService(ReaderFile readerFile, Recorder recorder, String htmlString) {
        this.readerFile = readerFile;
        this.recorder = recorder;
        this.htmlString = htmlString;
    }

    @Override
    public void writeFile() throws IOException {
        recorder.writeInFile(htmlString);
    }

    @Override
    public String readFile() throws IOException {
        return readerFile.readFromFile();
    }
}
