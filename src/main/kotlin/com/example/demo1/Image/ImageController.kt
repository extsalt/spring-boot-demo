package com.example.demo1.Image

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import java.awt.BasicStroke
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import javax.swing.Spring.height


@Controller
class ImageController {


    @GetMapping("/img")
    fun test() {
        this.createCanvas()
//        val bufferedReader = ImageIO.read(File("C:\\Users\\ganes\\Pictures\\IMG_20210924_162120.jpg"))
//        var graphic = bufferedReader.createGraphics()
//        graphic.color = Color.MAGENTA
//        graphic.stroke = BasicStroke(10F)
//        graphic.drawLine(0, bufferedReader.height - 20, 0, 0)
//        var file = File("test.jpg")
//        ImageIO.write(bufferedReader, "jpg", file)
    }

    fun createCanvas(width: Int = 640, height: Int = 480) {
        val bufferedImage = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
        val g2d = bufferedImage.createGraphics()
        g2d.background = Color.WHITE
        g2d.fillRect(0, 0, width, height)
        val file = File("test1.jpg")
        ImageIO.write(bufferedImage, "jpg", file)
    }
}