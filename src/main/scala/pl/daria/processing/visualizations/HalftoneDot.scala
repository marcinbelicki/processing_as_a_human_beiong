package pl.daria.processing.visualizations

import processing.core.PApplet.map
import processing.core.{PApplet, PImage}

trait HalftoneDot extends PApplet {

  private var img: PImage = _
  protected val tiles: Int = 35
  private lazy val tileSize: Float = 
    if (height > width) height / tiles 
    else width / tiles

  protected val scaleResolution: Float = 1
  
  protected def loadImage: PImage = loadImage("face_blurry.jpg")
  protected def scaledEntity(scale: Float): Unit = ellipse(0, 0, scale, scale)
  
  override def settings(): Unit = {
    img = loadImage
    img.resize((img.pixelWidth * scaleResolution).toInt, (img.pixelHeight * scaleResolution).toInt)
    size(img.pixelWidth, img.pixelHeight )
  }

  override def setup(): Unit = {
  }

  override def draw(): Unit = {
    background(0xF1F1F1)
    fill(0)
    noStroke()
    pushMatrix()
    for {
      x <- 0 until tiles
      y <- 0 until tiles
      c = img.get((x * tileSize).toInt, (y * tileSize).toInt)
      b = map(brightness(c), 0, 255, 1, 0)
    } {
      pushMatrix()
      translate(x * tileSize, y * tileSize)
      scaledEntity(b * tileSize)
      popMatrix()
    }
    popMatrix()
    if (frameCount == 1) saveFrame(s"${getClass.getSimpleName}/result.png")
  }
  
}
