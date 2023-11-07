package pl.daria.processing.visualizations.kinetic

import pl.daria.processing.ProcessingClassRunner
import processing.core.PConstants.{CENTER, P2D, TWO_PI}
import processing.core.{PApplet, PFont, PGraphics}

class KineticTypography extends Kinetic {

  protected lazy val pg: PGraphics = {
    val graphics = createGraphics(800, 800, P2D)
    graphics.beginDraw()
    graphics.background(0)
    graphics.fill(255)
    graphics.textFont(font)
    graphics.textSize(800)
    graphics.pushMatrix()
    graphics.translate(width * .5f, height * .5f - 140)
    graphics.textAlign(CENTER, CENTER)
    graphics.text('N', 0, 0)
    graphics.popMatrix()
    graphics.endDraw()

    graphics
  }

  private lazy val font: PFont = createFont("TT Hoves Pro Trial Bold.ttf", 600)
}

object KineticTypography extends ProcessingClassRunner[KineticTypography]
