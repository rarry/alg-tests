package pl.mjankowski.tests.algs

/**
 * Created by mjankowski on 2016-04-27.
 */
object Anagrams {

  def main(args: Array[String]): Unit = {
    val text = "example".toCharArray.toVector
    val anagrams = findAll(text)

    println("length: "+anagrams.length)
    anagrams foreach println
  }

  def findAll(s: Vector[Char]): Vector[Vector[Char]] =  {

    if(s.length == 1) Vector(Vector(s(0)))
    else{

      val listOfAnagrams = for(i <- (0 until s.length).toVector) yield{
        val ch = s(i)
        val tail = s.slice(0, i) ++ s.slice(i+1, s.length)
        findAll(tail) map (l => (ch +: l))
      }

      listOfAnagrams.flatten

    }
  }

}
