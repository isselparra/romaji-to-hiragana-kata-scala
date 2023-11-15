package transcription

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RomajiToHiraganaTranscriptorSpec extends AnyFlatSpec with Matchers {
  "transcript" should "return transcription a -> あ" in {
    RomajiToHiraganaTranscriptor.transcript("a") shouldBe "あ"
  }
  it should "return transcription ko -> こ" in {
    RomajiToHiraganaTranscriptor.transcript("ko") shouldBe "こ"
  }
  it should "return transcription x -> x" in {
    RomajiToHiraganaTranscriptor.transcript("x") shouldBe "x"
  }
  it should "return transcription neko -> ねこ" in {
    RomajiToHiraganaTranscriptor.transcript("neko") shouldBe "ねこ"
  }
  it should "return transcription tori -> とり" in {
    RomajiToHiraganaTranscriptor.transcript("tori") shouldBe "とり"
  }
  it should "return transcription Konnichiwa -> こんにちわ" in {
    RomajiToHiraganaTranscriptor.transcript("Konnichiwa") shouldBe "こんにちわ"
  }
}
