import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        useFile("testfile.txt");
        usePath("pathfile.txt");



    }



    private static void useFile(String fileName){

        File file = new File(fileName);
        boolean fileExists = file.exists();
        System.out.printf("File '%s' %s %n", fileName, fileExists? "exists" : "does not exist.");

        if(fileExists){
            System.out.println("Deleting file: " + fileName);
            fileExists = !file.delete();
        }

        if(!fileExists){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
        }
        System.out.println("Created file " + fileName);
        if(file.canWrite()){
            System.out.println("would write to the file here");
        }

    }


    private static void usePath(String fileName){

        Path path = Path.of(fileName);
        boolean fileExists = Files.exists(path);
        System.out.printf("File '%s' %s %n", fileName, fileExists? "exists" : "does not exist.");

        if(fileExists){
            System.out.println("Deleting file: " + fileName);
            try {
                Files.delete(path);
                fileExists = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!fileExists){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
        }
        System.out.println("Created file " + fileName);
        if(Files.isWritable(path)){
            System.out.println("would write to the file here");
        }

    }
}




