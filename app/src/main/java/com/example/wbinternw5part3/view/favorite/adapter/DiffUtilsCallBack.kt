package com.example.wbinternw5part3.view.favorite.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.wbinternw5part3.model.FavoriteData

class DiffUtilsCallBack(
    private val oldList: List<FavoriteData>,
    private val newList: List<FavoriteData>,
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].url == oldList[newItemPosition].url


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}