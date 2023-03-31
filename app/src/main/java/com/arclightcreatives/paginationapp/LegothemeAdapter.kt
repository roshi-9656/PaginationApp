package com.arclightcreatives.paginationapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.arclightcreatives.paginationapp.databinding.ListItemThemeBinding

class LegothemeAdapter (private val context: Context) : PagedListAdapter<LegoTheme, LegothemeAdapter.MyViewHolder>(USER_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ListItemThemeBinding = DataBindingUtil.inflate(inflater, R.layout.list_item_theme,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemBinding.legoTheme = getItem(position)
    }

    class MyViewHolder(val itemBinding: ListItemThemeBinding) : RecyclerView.ViewHolder(itemBinding.root){

        private var binding : ListItemThemeBinding? = null

        init {
            this.binding = itemBinding
        }

    }
    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<LegoTheme>() {
            override fun areItemsTheSame(oldItem: LegoTheme, newItem: LegoTheme): Boolean =
                oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: LegoTheme, newItem: LegoTheme): Boolean =
                newItem == oldItem
        }
    }

}