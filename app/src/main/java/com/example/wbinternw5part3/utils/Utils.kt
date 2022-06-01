package com.example.wbinternw5part3.utils

import com.example.wbinternw5part3.model.FavoriteData

fun sortingVoteList(list: List<FavoriteData>): List<FavoriteData> {
    val newList = arrayListOf<FavoriteData>()
    for (vote in list) {
        if (vote.value == 1)
            newList.add(vote)
    }
    return newList
}