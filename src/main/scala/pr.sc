import org.apache.log4j.Logger

abstract class Payment
case class PayTm(amount: Int) extends Payment

case class FreeCharge(amount: Int) extends Payment
case class NetBanking(amount: Int) extends Payment
case class CardPayment(amount: Int) extends Payment
case class Cash(amount: Int) extends Payment


object Application extends App{
  def calculatesFinalAmount(payment: Payment): String ={
    payment match{
      case PayTm(amount) => s"Final amount after PayTm payment is: ${amount + {amount*0.002}}"
      case FreeCharge(amount) => s"Final amount after PayTm payment is: ${amount + {amount*0.002}}"
      case NetBanking(amount) => s"Final amount after PayTm payment is: ${amount+5}"
      case CardPayment(amount) => s"Final amount after PayTm payment is: ${amount+1.5}"
      case Cash(amount) => s"Final amount after PayTm payment is: $amount"
    }



  }
  val log = Logger.getLogger(this.getClass)
  val cash = Cash(5)
  log.info(calculatesFinalAmount(cash))


}

