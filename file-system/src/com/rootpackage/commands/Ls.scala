package com.rootpackage.commands
import com.rootpackage.files.DirEntry
import com.rootpackage.filesystem.State

class Ls extends Command {
  override def apply(state: State): State = {
    val contents = state.workingDirec.con
    val output = createOutput(contents)
    state.setMessage(output)
  }
  def createOutput(content: List[DirEntry]): String = {
    if(content.isEmpty) ""
    else {
      val entry = content.head
      entry.name + "[" + entry.getType + "]\n" + createOutput(content.tail)
    }
  }
}
