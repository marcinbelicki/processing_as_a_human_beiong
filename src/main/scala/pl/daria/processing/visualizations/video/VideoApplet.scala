package pl.daria.processing.visualizations.video

import processing.core.PApplet

import java.io.File
import java.nio.file.{Path, Paths}

trait VideoApplet {
  this: PApplet =>
  private val videoLibsPath = new File("./video-libs").getCanonicalPath
  System.setProperty("jna.library.path", videoLibsPath)
}
