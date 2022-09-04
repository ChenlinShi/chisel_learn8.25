

import chisel3._
import chisel3.util._
class RegisterModule extends Module {
  val io = IO(new Bundle {
    val in  = Input(UInt(12.W))
    val out = Output(UInt(12.W))
  })
  
  val register = Reg(UInt(12.W))
  register := io.in + 1.U
  io.out := register
}

object RegisterModule  extends App {
  (new chisel3.stage.ChiselStage).emitVerilog(new RegisterModule())
    println(getVerilogString (new RegisterModule))
}
