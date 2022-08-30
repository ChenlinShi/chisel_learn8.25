import chisel3._
// Chisel Code: Declare a new module definition
// Chisel Code, but pass in a parameter to set widths of ports
class PassthroughGenerator(width: Int) extends Module { 
  val io = IO(new Bundle {
    val in = Input(UInt(width.W))
    val out = Output(UInt(width.W))
  })
  io.out := io.in
}

// Let's now generate modules with different widths
object PassthroughGenerator extends App {
  println(getVerilogString(new PassthroughGenerator(10)))
  println(getVerilogString(new PassthroughGenerator(20)))
}


