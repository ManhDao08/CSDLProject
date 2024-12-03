package com.example.Spring.Example.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageStorageService implements IStorageService {

    private final Path storageFolder = Paths.get("uploads");
    
    public ImageStorageService() {
        try {
            if (!Files.exists(storageFolder)) {
                Files.createDirectories(storageFolder);
                System.out.println(storageFolder + " " +storageFolder.toAbsolutePath());
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public boolean isImageFile(MultipartFile file) {
        try {
            if (file == null || file.isEmpty()) {
                throw new IllegalArgumentException("file không được tải hoặc file rỗng");
            } else {
                String fileName = file.getOriginalFilename();
                if (fileName == null || fileName.isEmpty()) {
                    throw new IllegalArgumentException("file không tồn tại");
                } else {
                    System.out.println(fileName.lastIndexOf('.') + " " + fileName.substring(fileName.lastIndexOf('.') + 1));
                    String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);
                    return Arrays.asList("png", "jpg", "jpeg", "bmp", "gif").contains(fileExtension.trim().toLowerCase());
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String storeFile(MultipartFile file) {
        // TODO Auto-generated method stub
        try {
            // File rỗng hay không hoặc upload có thất bại không.
            if (file.isEmpty()) {
                throw new RuntimeException("file is empty!");
            } 
            // File có phải file ảnh không
            if (!isImageFile(file)) {
                throw new RuntimeException("file is not image");
            }
            // File có dung lượng nhỏ hơn 5Mb không?
            float fileSizeInMegaBytes = file.getSize() / 1000000.0f;
            if (fileSizeInMegaBytes > 5.0f) {
                throw new RuntimeException("file's size must be < 5Mb");
            }
            // Tạo tên mới cho file
            // 1. Tạo tên file mới: 
            String targetFileNameExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
            String targetFileName = UUID.randomUUID().toString().replace("-", "") + targetFileNameExtension;
            // 2. Tạo Path dẫn đến file ảnh với tên file ảnh mới tạo: 
            System.out.println(storageFolder.toAbsolutePath() + " " + Paths.get(targetFileName).toAbsolutePath());
            Path destinationPath = this.storageFolder.resolve(Paths.get(targetFileName).normalize().toAbsolutePath());
            file.transferTo(destinationPath.toFile());
            return destinationPath.toString();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return "Upload file thất bại!";
        }
    }

    @Override
    public Stream<Path> loadAll() throws IOException {
        // TODO Auto-generated method stub
        return Files.list(storageFolder);
    }

    @Override
    public byte[] readFileContent(String fileName) throws IOException {
        // TODO Auto-generated method stub
        return Files.readAllBytes(storageFolder.resolve(fileName));
    }

    @Override
    public void deleteAllFile() throws IOException {
        // TODO Auto-generated method stub
        Stream<Path> listPaths = loadAll();
        listPaths.forEach(path -> {
            try {
                Files.delete(path);  
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    
}
