package alotra.milktea.service.Implements;

import alotra.milktea.Exception.StorageException;
import alotra.milktea.service.Interfaces.IStorageService;
import config.StorageProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageServiceImpl implements IStorageService {
    private final Path rootLocation;
    public FileSystemStorageServiceImpl(StorageProperties properties){
        this.rootLocation = Paths.get(properties.getLocation());
    }
    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
            System.out.println(rootLocation.toString());
        } catch (Exception e) {
            throw new StorageException("Could not read file: ", e);
        }
    }

    @Override
    public void delete(String storageFilename) throws Exception {
        Path destinationFile =
                rootLocation.resolve(Paths.get(storageFilename)).normalize().toAbsolutePath();
        Files.delete(destinationFile);
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            throw new StorageException("Can not read file: " + filename);
        } catch (Exception e) {
            throw new StorageException("Could not read file: " + filename);
        }
    }

    @Override
    public void store(MultipartFile file, String storeFilename) {
        try{
            if(file.isEmpty()){
                throw new StorageException("Failed to store empty file");
            }
            Path destinationFile = this.rootLocation.resolve(Paths.get(storeFilename))
                    .normalize().toAbsolutePath();
            if(!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())){
                throw new StorageException("Cannot store file outside curent dection");
            }
            try(InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream,destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
        }catch(Exception e)
        {
            throw new StorageException("Failed to store file: ",e);
        }
    }

    @Override
    public String getStorageFileName(MultipartFile file, String id) {
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        return "p" + id + "." + ext;
    }
}
