package com.tanzir.earthquakeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tanzir.earthquakeapp.databinding.EarthquakeItemRowBinding
import com.tanzir.earthquakeapp.models.EarthquakeModel
import com.tanzir.earthquakeapp.viewmodels.EarthquakeViewModel

class EarthquakeAdapter() :
    ListAdapter<EarthquakeModel.Metadata, EarthquakeAdapter.EarthquakeViewHolder>(EarthquakeDiff()) {

    class EarthquakeViewHolder(val binding: EarthquakeItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: EarthquakeModel.Metadata) {
            binding.item = item
        }
    }


    class EarthquakeDiff : DiffUtil.ItemCallback<EarthquakeModel.Metadata>() {
        override fun areItemsTheSame(
            oldItem: EarthquakeModel.Metadata,
            newItem: EarthquakeModel.Metadata
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: EarthquakeModel.Metadata,
            newItem: EarthquakeModel.Metadata
        ): Boolean {
            return oldItem == newItem
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EarthquakeViewHolder {
        val binding = EarthquakeItemRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return EarthquakeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EarthquakeViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}