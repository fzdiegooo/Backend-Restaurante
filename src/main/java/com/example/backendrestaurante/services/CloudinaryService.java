package com.example.backendrestaurante.services;

import com.cloudinary.Cloudinary;
import com.example.backendrestaurante.exceptions.FuncErrorException;
import com.example.backendrestaurante.models.dto.CloudinaryResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class CloudinaryService {
    @Autowired
    private Cloudinary cloudinary;

    @Transactional
    public CloudinaryResponse uploadFile(final MultipartFile file, final String fileName) {
        try {
            final Map result   = this.cloudinary.uploader()
                    .upload(file.getBytes(),
                            Map.of("public_id", fileName));
            final String url      = (String) result.get("secure_url");
            final String publicId = (String) result.get("public_id");
            return CloudinaryResponse.builder().public_id(publicId).url(url)
                    .build();

        } catch (final Exception e) {
            e.printStackTrace();
            throw new FuncErrorException("Failed to upload file");
        }
    }

    public boolean deleteFile(String publicId) {
        try {
            // Llamada a la API de Cloudinary para eliminar la imagen
            Map<String, Object> result = cloudinary.uploader()
                    .destroy(publicId, Map.of());

            // Verifica si la eliminación fue exitosa
            String resultStatus = (String) result.get("result");
            return "ok".equals(resultStatus);

        } catch (Exception e) {
            throw new FuncErrorException("Failed to delete file");
        }
    }
}
