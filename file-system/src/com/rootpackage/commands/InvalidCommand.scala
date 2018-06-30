package com.rootpackage.commands

import com.rootpackage.filesystem.State

class InvalidCommand extends Command {
  override def apply(state: State): State = state.setMessage("Invalid Command \n")
}
