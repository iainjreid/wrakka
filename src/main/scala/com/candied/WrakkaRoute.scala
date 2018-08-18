package com.candied

import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpResponse, StatusCodes}
import akka.http.scaladsl.server.{Directives, StandardRoute}

trait WrakkaRoute extends WrakkaContext with Directives {
  def complete[T](result: WrakkaResult[T])(implicit toString: T => String): StandardRoute = {
    complete(result.value match {
      case Right(response) => HttpResponse(StatusCodes.OK, entity = HttpEntity(ContentTypes.`application/json`, toString(response)))
      case Left(statusCode) => HttpResponse(statusCode)
    })
  }
}
