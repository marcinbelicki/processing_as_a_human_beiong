package pl.daria.processing.visualizations.kinetic

import pl.daria.processing.ProcessingClassRunner
import processing.core.{PConstants, PGraphics, PImage}

class KineticGraphics extends Kinetic {

  private lazy val image: PImage = loadImage("litera1.png")
  override protected lazy val pg: PGraphics = {
    val graphics = createGraphics(800, 800)
    graphics.beginDraw()
    graphics.background(0xffffffff)
    graphics.imageMode(PConstants.CENTER)
    graphics.image(image, 400, 400)
    graphics.endDraw()

    graphics
  }

  override def draw(): Unit = {
    super.draw()
    saveFrame("litera1/###.png")
  }
}

object KineticGraphics extends ProcessingClassRunner[KineticGraphics]
