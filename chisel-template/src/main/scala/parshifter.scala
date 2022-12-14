
import chisel3._
import chisel3.util._
class MyOptionalShiftRegister(val n: Int, val init: BigInt = 1) extends Module {
  val io = IO(new Bundle {
    val en  = Input(Bool())
    val in  = Input(Bool())
    val out = Output(UInt(n.W))
  })

  val state = RegInit(init.U(n.W))

  val nextState = (state << 1) | io.in
  when (io.en) {
    state  := nextState
  }
  io.out := state
}

object MyOptionalShiftRegister   extends App {
  (new chisel3.stage.ChiselStage).emitVerilog(new MyOptionalShiftRegister (8,1))
    println(getVerilogString (new MyOptionalShiftRegister(8,1) ))
}
