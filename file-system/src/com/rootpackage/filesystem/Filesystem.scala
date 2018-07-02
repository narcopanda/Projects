package com.rootpackage.filesystem


import com.rootpackage.commands.Command
import com.rootpackage.files.Directory

object Filesystem extends App {

  val root = Directory.Root

  io.Source.stdin.getLines().foldLeft(State(root, root))((currentState, newLine) => {
    val state = Command.from(newLine).apply(currentState)
    state.show
    state
  })
}
