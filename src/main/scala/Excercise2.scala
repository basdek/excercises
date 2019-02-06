import scala.concurrent.Future

object Exercise2 {

  case class User(id: String, name: String, petIds: List[String])

  case class Pet(id: String, name: String)

  case class PetOwner(user: User, pets: List[Pet])

  def getUser(id: String): Future[Option[User]] = ???

  def getPet(id: String): Future[Option[Pet]] = ???

  def getPetOwner(userId: String): Future[Option[PetOwner]] = {

  	// wrap apis above in actors

  	// implement PetOwnerLoader to load petowners so that at most 4 pets are loaded concurrently

  	// simpler version: 4 pets loaded concurrently per request (n.b.: this can be done very easily using streams, you can show how to do that as well, but the point of this exercise is implementing an actor) 

  	// how would you change it so that at most 4 pets are loaded concurrently for all requests

  	???

  }

  // class PetOwnerLoader(...) extends Actor { ... }

}
