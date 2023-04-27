package pl.daria.processing


import processing.core.PApplet

import scala.reflect.ClassTag


abstract class ProcessingClassRunner[T <: PApplet: ClassTag] {

  def main(args: Array[String]): Unit = {
    PApplet.main(implicitly[ClassTag[T]].runtimeClass, args: _*)
  }
}
