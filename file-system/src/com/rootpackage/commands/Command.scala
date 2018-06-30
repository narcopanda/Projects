package com.rootpackage.commands

import com.rootpackage.commands.Command.mkdir
import com.rootpackage.filesystem.State

trait Command extends (State => State)


object Command{

//  commands for  input
  val Ls = "ls"
  val mkdir = "mkdir"
  val Pwd ="pwd"
  val touch = "touch"
  val cd = "cd"
  val rm = "rm"
  val echo = "echo"
  val cat = "cat"

//  no commands
  def emptyCommand: Command = new Command {
    override def apply(state: State): State = state
  }

//  incomplete command
  def incompleteCommand(name: String): Command = new Command {
    override def apply(state: State): State = state.setMessage(name + ": incomplete command \n")
  }

//  checks the input for the command as call the corresponding command class
  def from(input:String): Command ={
    val tokens: Array[String] = input.split(" ")

    if(tokens.isEmpty || input.isEmpty) emptyCommand
    else tokens(0) match {
      case `mkdir` =>
        if(tokens.length < 2) incompleteCommand(mkdir)
        else new Mkdir(tokens(1))
      case Ls => new Ls
      case Pwd => new Pwd
      case `touch` =>
        if(tokens.length < 2) incompleteCommand(touch)
        else new Touch(tokens(1))
      case `cd` =>
        if(tokens.length < 2) incompleteCommand(cd)
        else new Cd(tokens(1))
      case `rm` =>
        if(tokens.length < 2) incompleteCommand(rm)
        else new Rm(tokens(1))
      case `echo` =>
        if(tokens.length < 2) incompleteCommand(echo)
        else new Echo(tokens.tail)
      case `cat` =>
        if(tokens.length < 2) incompleteCommand(cat)
        else new Cat(tokens(1))
      case _ =>  new InvalidCommand
    }



  }
}
