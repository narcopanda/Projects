package lectures.part1Basics

object DefaultArgs extends App {


  def tlFact(n: Int, acc:Int = 1):Int =
    if(n <= 1)acc
    else tlFact(n-1, n*acc)

  val fact10 = tlFact(10,1)

//  leading param can not have default args
  def savePicture(format:String = "jpg", width:Int = 1920, height: Int = 1080): Unit= println("saving pic")

  savePicture("jpg", 800, 600)
  savePicture("jpg")
  savePicture(width = 800) //name the args used

  /*
  1. pass in every leading args
  2. name the args
   */

  savePicture(height = 600, width = 800, format = "bmp")

}
