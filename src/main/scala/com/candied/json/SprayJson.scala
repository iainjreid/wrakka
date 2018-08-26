package com.candied.json

import spray.json._

trait SprayJson {
  /**
    * Implicitly convert the target value to a String. Assuming that there is a Spray JSON writer available within the
    * current context.
    *
    * @param writer
    * @tparam T
    * @return
    */
  implicit def valueToString[T](implicit writer: JsonWriter[T]): T => String =
    _.toJson.toString

  /**
    * Implicitly convert any Unit value to a String.
    *
    * @return
    */
  implicit def unitToString: Unit => String =
    _.toString
}

