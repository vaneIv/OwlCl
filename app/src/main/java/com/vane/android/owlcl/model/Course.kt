package com.vane.android.owlcl.model

import androidx.recyclerview.widget.DiffUtil

typealias CourseId = Long

data class Course(
    val id: CourseId,
    val name: String,
    val subject: String,
    val thumbUrl: String,
    val thumbContentDesc: String,
    val description: String = "",
    val steps: Int,
    val step: Int,
    val instructor: String = "https://i.pravatar.cc/112?$id"
)

object CourseDiff : DiffUtil.ItemCallback<Course>() {
    override fun areItemsTheSame(oldItem: Course, newItem: Course) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Course, newItem: Course) = oldItem == newItem
}

object CourseRepo {
    fun getCourse(id: CourseId) = courses.find { it.id == id } ?: courses.last()
}

val courses = listOf(
    Course(
        id = 0,
        name = "Basic Blocks and Woodturning",
        subject = "Arts & Crafts",
        thumbUrl = "https://source.unsplash.com/oJ7SV6vQfBA",
        thumbContentDesc = "",
        steps = 7,
        step = 1
    ),
    Course(
        id = 1,
        name = "An Introduction To Oil Painting On Canvas",
        subject = "Painting",
        thumbUrl = "https://source.unsplash.com/W9_sznrBmoA",
        thumbContentDesc = "",
        steps = 12,
        step = 1
    ),
    Course(
        id = 2,
        name = "Understanding the Composition of Modern Cities",
        subject = "Architecture",
        thumbUrl = "https://source.unsplash.com/s4I1xpX_ny8",
        thumbContentDesc = "",
        steps = 18,
        step = 1
    ),
    Course(
        id = 3,
        name = "Learning The Basics of Brand Identity",
        subject = "Design",
        thumbUrl = "https://source.unsplash.com/G9_Euqxpu4k",
        thumbContentDesc = "",
        steps = 22,
        step = 1
    ),
    Course(
        id = 4,
        name = "Wooden Materials and Sculpting Machinery",
        subject = "Arts & Crafts",
        thumbUrl = "https://source.unsplash.com/o54RjF-C7xo",
        thumbContentDesc = "",
        steps = 19,
        step = 1
    ),
    Course(
        id = 5,
        name = "Advanced Potter's Wheel",
        subject = "Arts & Crafts",
        thumbUrl = "https://source.unsplash.com/-LHvba-FgAo",
        thumbContentDesc = "",
        steps = 14,
        step = 1
    ),
    Course(
        id = 6,
        name = "Advanced Abstract Shapes & 3D Printing",
        subject = "Arts & Crafts",
        thumbUrl = "https://source.unsplash.com/HQkz_lWT_lY",
        thumbContentDesc = "",
        steps = 17,
        step = 1
    ),
    Course(
        id = 7,
        name = "Beginning Portraiture",
        subject = "Photography",
        thumbUrl = "https://source.unsplash.com/LE0Hp8l9gvs",
        thumbContentDesc = "",
        steps = 22,
        step = 1
    ),
    Course(
        id = 8,
        name = "Intermediate Knife Skills",
        subject = "Culinary",
        thumbUrl = "https://source.unsplash.com/f1xj_KeZ5RM",
        thumbContentDesc = "",
        steps = 14,
        step = 1
    ),
    Course(
        id = 9,
        name = "Pattern Making for Beginners",
        subject = "Fashion",
        thumbUrl = "https://source.unsplash.com/hew8-OoUriU",
        thumbContentDesc = "",
        steps = 7,
        step = 1
    ),
    Course(
        id = 10,
        name = "Location Lighting for Beginners",
        subject = "Photography",
        thumbUrl = "https://source.unsplash.com/pPxJTtxfV1A",
        thumbContentDesc = "",
        steps = 6,
        step = 1
    ),
    Course(
        id = 11,
        name = "Cinematography & Lighting",
        subject = "Film",
        thumbUrl = "https://source.unsplash.com/oIf4VCDztZY",
        thumbContentDesc = "",
        steps = 4,
        step = 1
    ),
    Course(
        id = 12,
        name = "Monuments, Buildings & Other Structures",
        subject = "Photography",
        thumbUrl = "https://source.unsplash.com/KxCJXXGsv9I",
        thumbContentDesc = "",
        steps = 4,
        step = 1
    )
)