package com.github.alexichlol.riot.api.dto.summoner

data class Summoner(val profileIconId: Int,
                    val name: String,
                    val summonerLevel: Long,
                    val revisionDate:  Long,
                    val id: Long,
                    val accountId: Long)