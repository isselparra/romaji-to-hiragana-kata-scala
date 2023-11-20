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
  it should "return transcription chi -> ち" in {
    RomajiToHiraganaTranscriptor.transcript("chi") shouldBe "ち"
  }
  it should "return transcription nana -> なな" in {
    RomajiToHiraganaTranscriptor.transcript("nana") shouldBe "なな"
  }
  it should "return transcription Son -> そん" in {
    RomajiToHiraganaTranscriptor.transcript("Son") shouldBe "そん"
  }
  it should "return transcription n -> ん" in {
    RomajiToHiraganaTranscriptor.transcript("n") shouldBe "ん"
  }
  it should "return transcription Sonna -> そんな" in {
    RomajiToHiraganaTranscriptor.transcript("Sonna") shouldBe "そんな"
  }
  it should "return transcription xx -> xx" in {
    RomajiToHiraganaTranscriptor.transcript("xx") shouldBe "xx"
  }
  it should "return transcription Konnichiwa -> こんにちわ" in {
    RomajiToHiraganaTranscriptor.transcript("Konnichiwa") shouldBe "こんにちわ"
  }
}
