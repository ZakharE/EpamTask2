import com.epam.task2_1.BinaryUtilClass;
import com.epam.custom_exeptions.EmptyFileException;
import com.epam.task2_2.SymbolUtilClass;
import org.junit.Assert;
import org.junit.Test;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;

public class SymbolUtilTest {
    @Test(expected = IOException.class)
    public void inputFileDoesNotExistShouldCatchException() throws IOException, EmptyFileException {
        String inputFileName = "asdasdggre";
        String outputFileName = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_2_resources\\test1.out";

        SymbolUtilClass.counter(inputFileName,outputFileName);
    }

    @Test(expected = IOException.class)
    public void outputFileDoesNotExistShouldCatchException() throws IOException, EmptyFileException {
        String inputFileName = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_2_resources\\test2.in";
        String outputFileName = "D:\\Projects\\IasddddwOstreams\\src\\main\\resources\\task2_2_resources\\test2.in";

        SymbolUtilClass.counter(inputFileName,outputFileName);
    }

    @Test(expected = EmptyFileException.class )
    public void tryingReadEmptyFileShouldReturnExeception() throws EmptyFileException, IOException{
        String inputFileName = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_2_resources\\test3.in";
        String outputFileName = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_2_resources\\test3.out";

        SymbolUtilClass.counter(inputFileName,outputFileName);
    }

    @Test
    public void bothFilesAreGoodShouldReturnCorrectAnswer() throws IOException {
        String answer = "new: 13\n" +
                "static: 1\n" +
                "public: 1\n" +
                "null: 4\n" +
                "for: 5\n" +
                "try: 1\n" +
                "catch: 2\n" +
                "if: 1\n" +
                "int: 9\n" +
                "return: 3\n" +
                "instanceof: 1";
        String outputFileName = "D:\\Projects\\EpamTask2\\src\\main\\resources\\task2_2_resources\\test4.out";

        Assert.assertEquals("The files differ!", answer,
                FileUtils.readFileToString(new File(outputFileName), "utf-8"));


    }
}
