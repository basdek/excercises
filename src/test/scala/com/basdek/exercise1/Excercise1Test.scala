package com.basdek.exercise1

import com.basdek.Exercise1
import org.specs2.Specification
import org.specs2.matcher.FutureMatchers

import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.Future

class Excercise1Test(implicit ec : ExecutionContext) extends Specification with FutureMatchers {

  class Exercise1InMemoryStorage extends Exercise1 {
    private val userInMemStorage: Map[String, User] = Map(
      "1" -> User("1", "John Doe", List("1", "2")),
      "2" -> User("1", "Jan Doedel", List.empty)
    )
    private val petInMemStorage : Map[String, Pet] = Map(
      "1" -> Pet("1", "Dog", List.empty),
      "2" -> Pet("2", "Cat", List.empty)
    )

    override def getUser(id: String): Future[Option[User]] = Future.successful(userInMemStorage.get(id))

    override def getPet(id: String): Future[Option[Pet]] = Future.successful(petInMemStorage.get(id))

  }



  def is = s2"""
  This is a specification to test the GetPetOwner method

  The 'getPetOwner' method should
    return a Nothing for a non existing User                   $t1
    return a Nothing for a User with an empty pet list         $t2
    return a PetOwner with all Pets for a User that owns pets  $t3
  """

  def t1 = {
    //Arrange
    val exercise1 : Exercise1 = new Exercise1InMemoryStorage
    //Act
    val result = exercise1.getPetOwner("nonExistingId")
    //Assert
    Await.result(result, Duration.Inf) must beNone
  }

  def t2 = {
    //Arrange
    val exercise1 : Exercise1 = new Exercise1InMemoryStorage
    //Act
    val result = exercise1.getPetOwner("2")
    val resultFinished  = Await.result(result, Duration.Inf)
    //Assert
    resultFinished must beNone
  }

  def t3 = {
    //Arrange
    val exercise1 : Exercise1 = new Exercise1InMemoryStorage
    //Act
    val result = exercise1.getPetOwner("1")
    val resultFinished = Await.result(result, Duration.Inf)
    //Assert
    resultFinished must beSome
    resultFinished.get.user.name must be ("John Doe")
    resultFinished.get.pets.map(x => x.name) must contain("Cat")
    resultFinished.get.pets.map(x => x.name) must contain("Dog")
  }

}
