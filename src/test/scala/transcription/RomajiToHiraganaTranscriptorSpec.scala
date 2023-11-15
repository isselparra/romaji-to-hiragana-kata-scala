package transcription

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RomajiToHiraganaTranscriptorSpec extends AnyFlatSpec with Matchers {
  "transcript" should "return Hello, world!" in {
    RomajiToHiraganaTranscriptor.transcript() shouldBe "Hello, world!"
  }
}
