import com.epam.task2_1.BinaryUtilClass;
import com.epam.custom_exeptions.EmptyFileException;
import org.junit.Assert;
import org.junit.Test;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;

public class BinaryUtilTest {
    @Test(expected = IOException.class)
    public void inputFileDoesNotExistShouldCatchException() throws IOException, EmptyFileException {
        String inputFileName = "asdasdggre";
        String outputFileName = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_1_resources\\test1.out";

        BinaryUtilClass.counter(inputFileName,outputFileName);
    }

    @Test(expected = IOException.class)
    public void outputFileDoesNotExistShouldCatchException() throws IOException, EmptyFileException {
        String inputFileName = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_1_resources\\test2.in";
        String outputFileName = "asd";

        BinaryUtilClass.counter(inputFileName,outputFileName);
    }

    @Test(expected = EmptyFileException.class )
    public void tryingReadEmptyFileShouldReturnExeception() throws EmptyFileException, IOException{
        String inputFileName = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_1_resources\\test3.in";
        String outputFileName = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_1_resources\\test3.out";

        BinaryUtilClass.counter(inputFileName,outputFileName);
    }

    @Test
    public void bothFilesAreGoodShouldReturnCorrectAnswer() throws IOException {
        String answer = "catch: 2\n" +
                "new: 13\n" +
                "static: 1\n" +
                "try: 1\n" +
                "public: 1\n" +
                "int: 4\n" +
                "instanceof: 1\n" +
                "return: 3\n";
        String inputFileName = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_1_resources\\test4.in";
        String outputFileName = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_1_resources\\test4.out";

        Assert.assertEquals("The files differ!",
                FileUtils.readFileToString(new File(outputFileName), "utf-8"), answer);


    }
}
