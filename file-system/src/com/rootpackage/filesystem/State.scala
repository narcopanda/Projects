package com.rootpackage.filesystem

import com.rootpackage.files.Directory

//hold the root and current directory
class State(val root: Directory, val workingDirec: Directory, val output: String) {

  def show: Unit = {
    println(output)
    print(State.shellToken)
  }

  def setMessage(message:String):State = State(root, workingDirec, message)


}


object State{
  val shellToken = "$ "

  def apply(root: Directory, workingDirec: Directory, output: String = ""): State =
    new State(root, workingDirec, output)
}
