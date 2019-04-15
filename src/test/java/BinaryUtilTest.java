import com.epam.task2_1.BinaryUtilClass;
import com.epam.custom_exeptions.EmptyFileException;
import org.junit.Assert;
import org.junit.Test;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BinaryUtilTest {
    @Test(expected = FileNotFoundException.class)
    public void inputFileDoesNotExistShouldCatchException() throws IOException, EmptyFileException {
        String inputFileName = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_1_resources\\test1.outaaa";
        String outputFileName = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_1_resources\\test1.out";

        BinaryUtilClass.counter(inputFileName,outputFileName);
    }

    @Test(expected = IOException.class)
    public void outputFileDoesNotExistShouldCatchException() throws IOException, EmptyFileException {
        String inputFileName = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_1_resources\\test2.in";
        String outputFileName = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_1_resources\\test2.inasd";

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
        String answer = "new: 13\n" +
                "static: 1\n" +
                "public: 1\n" +
                "try: 1\n" +
                "catch: 2\n" +
                "int: 4\n" +
                "return: 3\n" +
                "instanceof: 1\n";
        String outputFileName = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_1_resources\\test4.out";

        Assert.assertEquals("The files differ!", answer,
                FileUtils.readFileToString(new File(outputFileName), "utf-8"));


    }
}
