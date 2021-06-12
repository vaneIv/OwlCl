package com.vane.android.owlcl.model

import androidx.recyclerview.widget.DiffUtil

data class Lesson(
    val title: String,
    val formattedStepNumber: String,
    val length: String,
    val imageUrl: String,
    val imageContentDescription: String = ""
)

object LessonDiff : DiffUtil.ItemCallback<Lesson>() {
    override fun areItemsTheSame(oldItem: Lesson, newItem: Lesson) = oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: Lesson, newItem: Lesson) = oldItem == newItem
}

val lessons = listOf(
    Lesson(
        title = "An introduction to the Landscape",
        formattedStepNumber = "01",
        length = "4:14",
        imageUrl = "https://source.unsplash.com/NRQV-hBF10M"
    ),
    Lesson(
        title = "Movement and Expression",
        formattedStepNumber = "02",
        length = "7:28",
        imageUrl = "https://source.unsplash.com/JhqhGfX_Wd8"
    ),
    Lesson(
        title = "Composition and the Urban Canvas",
        formattedStepNumber = "03",
        length = "3:43",
        imageUrl = "https://source.unsplash.com/0OjzOqlJyoU"
    ),
    Lesson(
        title = "Lighting Techniques and Aesthetics",
        formattedStepNumber = "04",
        length = "4:45",
        imageUrl = "https://source.unsplash.com/J5-Kqu_fxyo"
    ),
    Lesson(
        title = "Special Effects",
        formattedStepNumber = "05",
        length = "6:19",
        imageUrl = "https://source.unsplash.com/9ZCZoH69dZQ"
    ),
    Lesson(
        title = "Techniques with Structures",
        formattedStepNumber = "06",
        length = "9:41",
        imageUrl = "https://source.unsplash.com/RFDP7_80v5A"
    ),
    Lesson(
        title = "Deep Focus Using a Camera Dolly",
        formattedStepNumber = "07",
        length = "4:43",
        imageUrl = "https://source.unsplash.com/0rZ2-QWtkwY"
    ),
    Lesson(
        title = "Point of View Shots with Structures",
        formattedStepNumber = "08",
        length = "9:41",
        imageUrl = "https://source.unsplash.com/iQnR_xEsBj0"
    ),
    Lesson(
        title = "Photojournalism: Street Art",
        formattedStepNumber = "09",
        length = "9:41",
        imageUrl = "https://source.unsplash.com/qX9Ie7ieb1E"
    )
)
