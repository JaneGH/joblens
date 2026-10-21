package com.itclimb.joblens.domain.model

data class Job(
    val id: Long = 0,
    val title: String? = null,
    val company: String? = null,
    val location: String? = null,
    val workType: WorkType? = null,
    val seniority: Seniority? = null,
    val salaryText: String? = null,
    val experienceText: String? = null,
    val originalDescription: String,
    val sourceUrl: String? = null,
    val requiredSkills: List<Skill> = emptyList(),
    val preferredSkills: List<Skill> = emptyList(),
    val status: ApplicationStatus = ApplicationStatus.SAVED,
)
