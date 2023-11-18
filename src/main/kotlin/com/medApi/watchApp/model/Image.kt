package com.medApi.watchApp.model

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Entity
@Table(name = "IMAGE")
@Getter
@Setter
data class Image(
    @Id
    @Column(name = "id", nullable = false)
    var id: Int,

    @Column(name = "name", nullable = false)
    var name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    var person: Person,

    @Column(name = "orig_image")
    var origImage: ByteArray,

    @Column(name = "segment_image")
    var segmentImage: ByteArray,

    @Column(name = "detect_image")
    var detectImage: ByteArray,

    @Column(name = "labeled_image")
    var labeledImage: ByteArray,

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Image

        if (id != other.id) return false
        if (name != other.name) return false
        if (person != other.person) return false
        if (!origImage.contentEquals(other.origImage)) return false
        if (!segmentImage.contentEquals(other.segmentImage)) return false
        if (!detectImage.contentEquals(other.detectImage)) return false
        return labeledImage.contentEquals(other.labeledImage)
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + person.hashCode()
        result = 31 * result + origImage.contentHashCode()
        result = 31 * result + segmentImage.contentHashCode()
        result = 31 * result + detectImage.contentHashCode()
        result = 31 * result + labeledImage.contentHashCode()
        return result
    }
}


