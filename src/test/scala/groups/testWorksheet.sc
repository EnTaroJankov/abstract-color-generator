import java.awt.Graphics
import java.awt.image.BufferedImage
import java.io.File
import java.util

import groups.{AdditiveIntegerGroup, IntegerGroup, MultiplicativeIntegerGroup}
import javax.imageio.ImageIO
import javax.swing.{ImageIcon, JFrame, JLabel}


val intPow = (base: Int, exponent: Int) => scala.math.pow(base, exponent).intValue()

val x: Int = 29059

val aGroup = new AdditiveIntegerGroup(x)

val mGroup = new MultiplicativeIntegerGroup(x)

def spacer(rgb: Int, x: Int): Int = {
  val max: Int = 2147483647
  val chunk: Double = max / x
  if (rgb < x / 2) {
    -2147483648 + (chunk * rgb).intValue()
  } else {
    (chunk * rgb).intValue()
  }
}

//def spacer(rgb: Int, x: Int): Int = {
//  var max: Int = 2147483647
//  val chunk: Double = max / x
////  if (rgb < x / 2) {
////    -2147483648 + (chunk * rgb).intValue()
////  } else {
//  (chunk * rgb).intValue()
////  }
//}

def listPowerSequence(group: IntegerGroup, img: BufferedImage): Unit = {
  for (base: Int <- 0 until x) {
    val values: util.Iterator[Int] = group.op(base, x)
    for (exponent: Int <- 0 until x) {
      val g: Int = values.next()
      img.setRGB(base, exponent, spacer(g, x))
      // img.setRGB(base, exponent, g << 12)
    }
  }
}

var img = new BufferedImage(x, x, BufferedImage.TYPE_INT_RGB)

//var img = new BufferedImage(x, x, BufferedImage.TYPE_4BYTE_ABGR)

var go: Graphics = img.getGraphics

listPowerSequence(aGroup, img)

// listPowerSequence(mGroup, img)

go.drawImage(img, 0, 0, null)

val picLabel = new JLabel(new ImageIcon(img))

val frame: JFrame = new JFrame("ColorPan")
frame.setSize(x, x)
// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
frame.setContentPane(picLabel)
frame.setVisible(true)

var fd1 = new File("100oko69_addition.png")

println(ImageIO.write(img, "png", fd1))


