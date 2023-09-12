package pl.daria.processing.visualizations

import pl.daria.processing.ProcessingClassRunner
import pl.daria.processing.visualizations.video.VideoApplet
import processing.core.PApplet.{exp, map}
import processing.core.PApplet
import processing.video.Movie

class HalftoneMovie extends PApplet with VideoApplet {

  private lazy val movie: Movie = new Movie(this, "noise.mp4")
  protected val tiles: Int = 35
  private lazy val tileSize: Float =
    if (height > width) height / tiles
    else width / tiles

  protected val scaleResolution: Float = 1

  protected def scaledEntity(scale: Float): Unit = ellipse(0, 0, scale, scale)

  override def settings(): Unit = {
    movie.resize((movie.pixelWidth * scaleResolution).toInt, (movie.pixelHeight * scaleResolution).toInt)
    size(movie.pixelWidth, movie.pixelHeight)
  }

  override def setup(): Unit = {
    movie.play()
  }

  override def draw(): Unit = {
    background(0xF1F1F1)
    fill(0)
    noStroke()
    pushMatrix()
    for {
      x <- 0 until tiles
      y <- 0 until tiles
      c = movie.get((x * tileSize).toInt, (y * tileSize).toInt)
      b = map(brightness(c), 0, 255, 1, 0)
    } {
      pushMatrix()
      translate(x * tileSize, y * tileSize)
      scaledEntity(b * tileSize)
      popMatrix()
    }
    popMatrix()
    if (frameCount == 1) saveFrame(s"${getClass.getSimpleName}/result_###.png")
  }

}

object HalftoneMovie extends ProcessingClassRunner[HalftoneMovie]
