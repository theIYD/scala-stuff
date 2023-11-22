package models

import play.api.libs.json.{Json, Reads, Writes}

case class User(
               id: String = "USR-001",
               name: String = "KAY",
               age: Int = 76
               )

object User {
  implicit val userReads: Reads[User] = Json.reads[User]
  implicit val userWrites: Writes[User] = Json.writes[User]
}