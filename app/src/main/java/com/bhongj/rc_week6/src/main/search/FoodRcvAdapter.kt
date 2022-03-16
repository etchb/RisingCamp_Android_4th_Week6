package com.bhongj.rc_week6.src.main.search

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bhongj.rc_week6.databinding.FoodItemRecyclerBinding
import com.bhongj.rc_week6.src.main.search.restrntModel.Row

class FoodRcvAdapter(private val dataList: MutableList<Row>) :
    RecyclerView.Adapter<FoodRcvAdapter.ViewHolder>() {
    private lateinit var binding: FoodItemRecyclerBinding

    class ViewHolder(binding: FoodItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        var imgFoodView: ImageView = binding.rcyImgFood
        var imgStar: ImageView = binding.rcyImgStar
        var region: TextView = binding.rcyTxtRegion
        var restrntNameView: TextView = binding.rcyTxtRestrntName
        var restrntType: TextView = binding.rcyTxtRestrntType
        var rateView: TextView = binding.rcyTxtRate

        init {
            // Define click listener for the ViewHolder's View.
        }

        fun bind(item: Row) {
            imgFoodView.setImageResource(item.PIC)
            region.text = item.SIGNGU_NM
            restrntNameView.text = item.BIZPLC_NM
            restrntType.text = item.INDUTYPE_DETAIL_NM
            rateView.text = item.RATE.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding =
            FoodItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]

        holder.bind(item)
    }

    override fun getItemCount() = dataList.size
}