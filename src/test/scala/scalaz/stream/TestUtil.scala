package scalaz.stream

import scala.concurrent.duration._

/**
 * Various testing helpers
 */
private[stream] object TestUtil {

  /** simple timing test, returns the duration and result **/
  def time[A](a: => A, l: String = ""): (FiniteDuration, A) = {
    val start = System.currentTimeMillis()
    val result = a
    val stop = System.currentTimeMillis()
  //  println(s"$l took ${(stop - start) / 1000.0 } seconds")
    ((stop - start).millis, result)
  }

  /** like `time` but will return time per item based on times supplied **/
  def timePer[A](items:Int)(a: => A, l: String = ""): (FiniteDuration, A) = {
    val (tm, ra) = time(a,l)
    (tm / items, ra)
  }


}
