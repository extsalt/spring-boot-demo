package com.example.demo1.Image

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import java.awt.BasicStroke
import java.awt.Color
import java.awt.Font
import java.awt.Graphics
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO


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

    fun createCanvas(width: Int = 640, height: Int = 480, agree: Float = .75F, disagree: Float = .25F) {
        val bufferedImage = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
        val graphic = bufferedImage.createGraphics()
        graphic.background = Color.WHITE
        graphic.fillRect(0, 0, width, height)
        val currentFont: Font = graphic.font
        val newFont = currentFont.deriveFont(currentFont.size * 1.4f)
        graphic.font = newFont

        graphic.color = Color.BLACK
        val summary = this.getSummary()
        this.drawString(graphic, summary, 10, 20)
        graphic.color = Color.GREEN
        graphic.stroke = BasicStroke(10F)

        graphic.drawLine(0, (0.75 * height).toInt(), (agree * width).toInt(), (0.75 * height).toInt())
        graphic.color = Color.RED
        graphic.drawLine((agree * width).toInt(), (0.75 * height).toInt(), width, (0.75 * height).toInt())
        //draw percentage of agree and disagree here
        val agreeCount = (100 * agree).toInt()
        val disagreeCount = (100 * disagree).toInt()

        graphic.drawString("$agreeCount | $disagreeCount", 0, (0.70 * height).toInt())
        val file = File("test1.jpg")
        ImageIO.write(bufferedImage, "jpg", file)
    }

    fun getSummary(): String {
        return "Lorem Ipsum is simply dummy text of the printing and typesetting industry. \n" +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an\n" +
                " unknown printer took a galley of type and scrambled it to make a type specimen book\n" +
                ". It has survived not only five centuries, but also the leap into electronic typesetting\n"
    }

    fun drawString(g: Graphics?, text: String?, x: Int, y: Int) {
        var y = y

        for (line in text!!.split("\n").toTypedArray())
            g!!.drawString(line, x, g.fontMetrics.height.let { y += it; y })
    }
}