package pl.daria.processing.visualizations.kinetic

import processing.core.PConstants.{P2D, TWO_PI}
import processing.core.{PApplet, PGraphics}
trait Kinetic extends PApplet  {

  protected def pg: PGraphics

  override def settings(): Unit = {
    size(800, 800, P2D)
  }

  private val tilesX = 8
  private val tilesY = 8

  private lazy val tileW: Int = width / tilesX
  private lazy val tileH: Int = height / tilesY

  override def setup(): Unit = ()

  override def draw(): Unit = {
    background(0)
    image(pg, 0, 0)
    for {
      x <- 0 until tileW
      y <- 0 until tileH
      wave = (Math.sin(frameCount * (x + y) * TWO_PI * .005) * 100).toInt
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
