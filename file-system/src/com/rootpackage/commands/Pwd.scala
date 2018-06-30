package com.rootpackage.commands
import com.rootpackage.filesystem.State

class Pwd extends Command {

  override def apply(state: State): State = state.setMessage(state.workingDirec.path)
}
