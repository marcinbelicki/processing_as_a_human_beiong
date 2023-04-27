package pl.daria.processing.visualizations

import pl.daria.processing.ProcessingClassRunner
import processing.core.PConstants.{CENTER, P2D, TWO_PI}
import processing.core.{PApplet, PFont, PGraphics}

class KineticTypography extends PApplet {

  private var pg: PGraphics = _
  private var font: PFont = _

  override def settings(): Unit = {
    size(800, 800, P2D)
  }

  private val tilesX = 8
  private val tilesY = 8

  private var tileW: Int = _
  private var tileH: Int = _

  override def setup(): Unit = {
    font = createFont("TT Hoves Pro Trial Bold.ttf", 600)
    pg = createGraphics(800, 800, P2D)
    tileW = width / tilesX
    tileH = height / tilesY
  }

  override def draw(): Unit = {
    background(0)

    pg.beginDraw()
    pg.background(0)
    pg.fill(255)
    pg.textFont(font)
    pg.textSize(800)
    pg.pushMatrix()
    pg.translate(width * .5f, height * .5f - 140)
    pg.textAlign(CENTER, CENTER)
    pg.text('N', 0, 0)
    pg.popMatrix()
    pg.endDraw()

    image(pg, 0, 0)

    for {
      x <- 0 until tileW
      y <- 0 until tileH
      wave = (Math.sin(frameCount * (x + y)  * TWO_PI * .005) * 100 ).toInt
      sx = x * tileW + wave
      sy = y * tileH
      sw = tileW
      sh = tileH

      dx = x * tileW
      dy = y * tileH
      dw = tileW
      dh = tileH
    } copy(pg, sx, sy, sw, sh, dx, dy, dw, dh)


  }
}

object KineticTypography extends ProcessingClassRunner[KineticTypography]
