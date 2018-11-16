package com.github.alexichlol.riot.api.dto.champion

data class ChampionInfo(val freeChampionIdsForNewPlayers: List<Int>,
                        val freeChampionIds: List<Int>,
                        val maxNewPlayerLevel: Int)