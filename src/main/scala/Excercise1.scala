object Exercise1 {

  import scala.concurrent.Future

  case class User(id: String, name: String, petIds: List[String])

  case class Pet(id: String, name: String, petIds: List[String])

  case class PetOwner(user: User, pet: List[Pet])

  def getUser(id: String): Future[Option[User]] = ???

  def getPet(id: String): Future[Option[Pet]] = ???

  // Implement this

  def getPetOwner(userId: String): Future[Option[PetOwner]] = ???

}
