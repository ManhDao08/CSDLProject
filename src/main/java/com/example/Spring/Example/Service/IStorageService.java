package com.example.Spring.Example.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {

    /** Lưu file.
     * 
     * file không được empty.
     * file phải là file ảnh.
     * file phải nhỏ hơn một kích cỡ nào đó.
     * @param file
     * @return
     */
    public String storeFile(MultipartFile file);
    // Tải tất cả ảnh lên.
    public Stream<Path> loadAll() throws IOException;
    // Đọc nội dung một file biết tên file.
    public byte[] readFileContent(String fileName) throws IOException;
    // Xóa tát cả các file.(??? Ở đâu. Có thể là trong folder lưu trữ ảnh)
    public void deleteAllFile() throws IOException;

}