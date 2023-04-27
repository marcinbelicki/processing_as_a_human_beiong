package pl.daria.processing.visualizations

import pl.daria.processing.ProcessingClassRunner
import processing.core.{PFont, PImage}

class HalftoneChars extends HalftoneDot {

  private lazy val font: PFont = createFont("TT Hoves Pro Trial Bold.ttf", 600)
  private val text: String = "йłČф"

  override protected val tiles = 300
  
  override protected val scaleResolution: Float = 3

  override def loadImage: PImage = loadImage("kotki.png")

  override def setup(): Unit = {
    super.setup()
    g.textFont(font)
  }

  override protected def scaledEntity(scale: Float): Unit = {
    val scaleCorrected = if (scale < Float.MinPositiveValue) Float.MinPositiveValue
    else scale
    g.textSize(scaleCorrected)
    g.text(text, 0, 0)
  }

}

object HalftoneChars extends ProcessingClassRunner[HalftoneChars]
