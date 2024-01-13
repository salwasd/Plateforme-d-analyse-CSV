package ma.backend;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Utilities {
    public static File MultipartFileToFile(MultipartFile multipartFile){
        File _file = new File(multipartFile.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(_file)) {
            fos.write(multipartFile.getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  _file;
    }
}
