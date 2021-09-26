package com.example.demo1.Image

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import java.io.File
import javax.imageio.ImageIO

@Controller
class ImageController {


    @GetMapping("/img")
    fun test() {
        val bufferedReader = ImageIO.read(File("C:\\Users\\ganes\\Pictures\\IMG_20210924_162120.jpg"))
        bufferedReader.graphics.drawRect(0, bufferedReader.height - 20, 80, 80)
        var file = File("test.jpg")
        ImageIO.write(bufferedReader, "jpg", file)
    }
}