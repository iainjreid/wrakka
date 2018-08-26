package com.candied

import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpResponse}
import akka.http.scaladsl.server.{Directives, StandardRoute}

trait WrakkaRoute extends WrakkaContext with Directives {
  /**
    * Expand a WrakkaResult, and handle the value inside the Either appropriately.
    *
    * @param result
    * @param toString
    * @tparam T
    * @return
    */
  def complete[T](result: WrakkaResult[T])(implicit toString: T => String): StandardRoute = {
    complete(result.value.map {
      case Right(response) => HttpResponse(entity = HttpEntity(ContentTypes.`application/json`, toString(response)))
      case Left(statusCode) => HttpResponse(statusCode)
    })
  }
}
