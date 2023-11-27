package alotra.milktea.service.Interfaces;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;

public interface IStorageService {
    void init();
    void delete(String storageFilename) throws Exception;
    Path load(String filename);
    Resource loadAsResource(String fileName);
    void store(MultipartFile file, String storeFilename);
    String getStorageFileName(MultipartFile file, String id);
}
