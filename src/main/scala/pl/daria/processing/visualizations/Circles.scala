package pl.daria.processing.visualizations

import pl.daria.processing.ProcessingClassRunner
import processing.core.PApplet.map
import processing.core.{PApplet, PImage}

class Circles extends PApplet {
  
  private var img: PImage = _
  private val tiles: Int = 35
  private lazy val tileSize: Float = height / tiles

  override def settings(): Unit = {
    size(795, 1136)
  }
  
  override def setup(): Unit = {
    img = loadImage("face_blurry.jpg")
    
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
      ellipse(0, 0, b * tileSize, b * tileSize)
      popMatrix()
    }
    popMatrix()
  }
}

object Circles extends ProcessingClassRunner[Circles]
