package pksp.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("static")
public class ImageController {
    private final String imagePath;

    public ImageController(@Value("${image.file.path}")String imagePath) {
        this.imagePath = imagePath;
    }

    @GetMapping(
            value = "/image/{imageName}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public byte[] getImageWithMediaType(@PathVariable("imageName") String imageName) throws IOException {
        String path = imagePath + File.separator + imageName;
        File img = new File(path);
        InputStream in = new FileInputStream(img);

        return IOUtils.toByteArray(in);
    }
}
