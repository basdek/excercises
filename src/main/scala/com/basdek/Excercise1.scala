package com.basdek

import cats.data.{Nested, OptionT}
import cats.implicits._

class Exercise1 {

  import scala.concurrent.Future

  //User 1:n Pet
  case class User(id: String, name: String, petIds: List[String])

  //Why do pets have a list of petIds? What does that represent?
  //I assume a mistake, since in Exercise 2 a Pet has no petIds list...
  case class Pet(id: String, name: String, petIds: List[String])

  case class PetOwner(user: User, pets: List[Pet]) //Pluralized name.

  def getUser(id: String): Future[Option[User]] = ???

  def getPet(id: String): Future[Option[Pet]] = ???

  // Implement this



  def getPetOwner(userId: String) : Future[Option[PetOwner]] = {

    val chain : OptionT[Future, PetOwner] = for {
      user <- OptionT(getUser(userId))
      petIds = user.petIds
      pets  <- (petIds.map(id => OptionT(getPet(id)))).sequenceU
      if(!petIds.isEmpty)
    } yield PetOwner(user, pets)

    chain.value

  }

}
