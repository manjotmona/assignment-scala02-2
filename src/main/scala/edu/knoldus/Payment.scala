package edu.knoldus

import org.apache.log4j.Logger

/**
 * Created by manjot on 16/1/18.
 */
abstract class Payment

case class PayTm(amount: Int) extends Payment

case class FreeCharge(amount: Int) extends Payment

case class NetBanking(amount: Int) extends Payment

case class CardPayment(amount: Int) extends Payment

case class Cash(amount: Int) extends Payment

object Application extends App {
  def calculatesFinalAmount(payment: Payment): String = {
    payment match {
      case PayTm(amount) => s"Final amount after PayTm payment is: ${ amount + { amount * 0.02 } }"
      case FreeCharge(amount) => s"Final amount after FreeCharge payment is: ${
        amount + { amount * 0.02 }
      }"
      case NetBanking(amount) => s"Final amount after NetBanking payment is: ${ amount + 5 }"
      case CardPayment(amount) => s"Final amount after CardPayment payment is: ${ amount + 1.5 }"
      case Cash(amount) => s"Final amount after Cash payment is: $amount"
    }
  }
  val log = Logger.getLogger(this.getClass)
  val five = 100
  val payTm = PayTm(five)
  log.info(calculatesFinalAmount(payTm) + "\n")
  val freeCharge = FreeCharge(five)
  log.info(calculatesFinalAmount(freeCharge) + "\n")
  val netBank = NetBanking(five)
  log.info(calculatesFinalAmount(netBank) + "\n")
  val cardPayment = CardPayment(five)
  log.info(calculatesFinalAmount(cardPayment) + "\n")
  val cash = Cash(five)
  log.info(calculatesFinalAmount(cash) + "\n")
}
