package com.example.demo1.Image

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import java.awt.BasicStroke
import java.awt.Color
import java.awt.Graphics2D
import java.io.File
import javax.imageio.ImageIO

@Controller
class ImageController {


    @GetMapping("/img")
    fun test() {
        val bufferedReader = ImageIO.read(File("C:\\Users\\ganes\\Pictures\\IMG_20210924_162120.jpg"))
        var graphic = bufferedReader.createGraphics()
        graphic.color = Color.MAGENTA
        graphic.stroke = BasicStroke(10F)
        graphic.drawLine(0, bufferedReader.height - 20, 0,0)
        var file = File("test.jpg")
        ImageIO.write(bufferedReader, "jpg", file)
    }
}