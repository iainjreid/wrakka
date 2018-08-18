package com.candied

import spray.json._

trait SprayJson {
  implicit def valueToString[T](value: T)(implicit writer: JsonWriter[T]): String = {
    value.toJson.toString
  }
}

