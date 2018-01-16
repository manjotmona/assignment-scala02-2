package edu.knoldus

import org.apache.log4j.Logger

/**
 * Created by manjot on 16/1/18.
 */

case class Blog(technology: String, numberOfBlogs: Int)

abstract class Person

case class Gamer(number: Int) extends Person

case class Trainer(attendance: Int) extends Person

case class Blogger(blogList: Map[String, Int]) extends Person {

  def writeBlog(technology: String): Blogger = {
    val oldTechCount = this.blogList.get(technology)
    val updatedNum = oldTechCount.fold(1)(_ + 1)
    if (oldTechCount == None) {
      Blogger(this.blogList + (technology -> updatedNum))
    }
    else {
      Blogger(this.blogList updated(technology, updatedNum))
    }
  }
}

//object Application extends App {
//  def displaysResponse(person: Person): String = {
//    person match {
//      case Gamer(number) => playerPlays(number)
//      case Trainer(attendance) => s"Today's attendance is $attendance."
//      case Blogger(blogList) => blogList.maxBy(_._2)._1 +
//                                " is the favourite Technology of this author."
//    }
//  }
//
//  def playerPlays(number: Int): String = {
//    if (number == 3) {
//      "Player is a Winner."
//    }
//    else if (number == 0 || number == 1 || number == 2) {
//      "Player is a Loser."
//    }
//    else {
//      "Player Cheated"
//    }
//  }
//
//  val log = Logger.getLogger(this.getClass)
//  val r = scala.util.Random
//  val four = 4
//  val numberOfOnesOrSixes = r.nextInt(four)
//  val gamer = Gamer(numberOfOnesOrSixes)
//  log.info(displaysResponse(gamer) + "\n")
//  val fiftyOne = 51
//  val trainer = Trainer(r.nextInt(fiftyOne))
//  log.info(displaysResponse(trainer) + "\n")
//  val initialBlogList = Map("Java" -> 1, "Kafka" -> 1, "Scala" -> 2)
//  val domain = List("Scala", "Java", "Kafka")
//  val randomIndex1 = r.nextInt(3)
//  val blogger = Blogger(initialBlogList)
//  val blogger1 = blogger.writeBlog(domain(randomIndex1))
//  val randomIndex2 = r.nextInt(3)
//  val blogger2 = blogger1.writeBlog(domain(randomIndex2))
//  val randomIndex3 = r.nextInt(3)
//  val blogger3 = blogger2.writeBlog(domain(randomIndex3))
//  val randomIndex4 = r.nextInt(3)
//  val blogger4 = blogger3.writeBlog(domain(randomIndex4))
//  val randomIndex5 = r.nextInt(3)
//  val blogger5 = blogger4.writeBlog(domain(randomIndex5))
//  log.info(displaysResponse(blogger5))
//}

