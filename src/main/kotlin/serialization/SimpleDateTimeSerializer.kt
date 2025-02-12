package serialization

import model.SimpleDateTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object SimpleDateTimeSerializer : KSerializer<SimpleDateTime> {
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("SimpleDateTime", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: SimpleDateTime) {

        encoder.encodeString(value.getDateTime().format(formatter))
    }

    override fun deserialize(decoder: Decoder): SimpleDateTime {
        val dateString = decoder.decodeString()
        val dateTime = LocalDateTime.parse(dateString, formatter)
        return SimpleDateTime(dateTime)
    }
}