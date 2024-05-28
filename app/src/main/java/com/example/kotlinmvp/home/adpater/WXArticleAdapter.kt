package com.example.kotlinmvc.home.adpater

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.baselib.bean.WXArticleBean
import com.example.baselib.impl.NoMultiClickListener
import com.example.kotlinmvp.R

/**
 *Author: chinadragon
 *Time: 2024/5/27
 */
class WXArticleAdapter(
    val mDatas: MutableList<WXArticleBean> = mutableListOf(),
    val callBack: (WXArticleBean) -> Unit
) : RecyclerView.Adapter<WXArticleAdapter.WXArticleViewHodler>() {

    inner class WXArticleViewHodler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tvName)!!
        val tvOrder = itemView.findViewById<TextView>(R.id.tvOrder)!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WXArticleViewHodler {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_wxarticle, parent, false)
        return WXArticleViewHodler(view)
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    override fun onBindViewHolder(holder: WXArticleViewHodler, position: Int) {
        val wxArticleBean = mDatas[position]
        with(wxArticleBean) {
            holder.tvOrder.text = "${order ?: ""}"
            holder.tvName.text = name
        }

        holder.itemView.setOnClickListener(NoMultiClickListener {
            callBack(wxArticleBean)
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(datas: List<WXArticleBean>?) {
        if (datas.isNullOrEmpty()) {
            return
        }
        mDatas.clear()
        mDatas.addAll(datas)
        notifyDataSetChanged()
    }

}