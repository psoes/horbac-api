package com.uds.horbac.core.service.common;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.uds.horbac.core.exceptions.FileStorageException;

@Service
public class FileService {

    //@Value("${app.upload.dir:${user.home}}")
	@Value("${app.upload.dir}")
    public String uploadDir;    

	private final Path root = Paths.get("uploads");
	
	public void init() {
	    try {
	      Files.createDirectory(root);
	    } catch (IOException e) {
	      throw new RuntimeException("Could not initialize folder for upload!");
	    }
	  }

    public Resource uploadFile(String fid, MultipartFile file) {
    	Resource resource = null;
    	try {
    		Path dir = Paths.get(uploadDir);
    		if (!Files.exists(dir)) {
    		    this.init();
    		}
            Path copyLocation = Paths
                .get(uploadDir + File.separator +fid+ StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            
            Path file1 = Paths.get(uploadDir).resolve(copyLocation);
            resource = new UrlResource(file1.toUri());

  	     /* if (resource.exists() || resource.isReadable()) {
  	        return resource;
  	      } */
  	        
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Could not store file " + file.getOriginalFilename()
                + ". Please try again!");
        }
    	return resource;
    }

	  public void save(MultipartFile file) {
	    try {
	      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
	    } catch (Exception e) {
	      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
	    }
	  }

	  public Resource load(String filename) {
	    try {
	      Path file = Paths.get(uploadDir).resolve(filename);
	      System.out.println("FILE name :"+file);
	      Resource resource = new UrlResource(file.toUri());

	      if (resource.exists() || resource.isReadable()) {
	        return resource;
	      } else {
	        throw new RuntimeException("Could not read the file!");
	      }
	    } catch (MalformedURLException e) {
	      throw new RuntimeException("Error: " + e.getMessage());
	    }
	  }

	  public void deleteAll() {
	    FileSystemUtils.deleteRecursively(root.toFile());
	  }

	  public Stream<Path> loadAll() {
	    try {
	      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
	    } catch (IOException e) {
	      throw new RuntimeException("Could not load the files!");
	    }
	  }
    }
