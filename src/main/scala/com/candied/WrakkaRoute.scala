package com.candied

import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpResponse, StatusCodes}
import akka.http.scaladsl.server.{Directives, StandardRoute}
import spray.json.JsonWriter

trait WrakkaRoute[M[_]] extends WrakkaContext[M] with Directives {
  def complete[T](result: WrakkaResult[T])(implicit writer: JsonWriter[T]): StandardRoute = {
    complete(result.value.map {
      case Right(response) => HttpResponse(StatusCodes.OK, entity = HttpEntity(ContentTypes.`application/json`, response.toJson.toString))
      case Left(statusCode) => HttpResponse(statusCode)
    })
  }
}
